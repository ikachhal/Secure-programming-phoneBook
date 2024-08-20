package com.cse5382.assignment.Service;

import com.cse5382.assignment.Model.PhoneBookResponse;
import com.cse5382.assignment.Repository.PhoneBookEntryRepository;
import com.cse5382.assignment.Repository.PhoneBookRepository;
import com.cse5382.assignment.Model.PhoneBookEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class PhoneBookServiceImpl implements PhoneBookService{
    @Autowired
    PhoneBookRepository phoneBookRepository;

    @Autowired
    PhoneBookEntryRepository phoneBookEntryRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneBookServiceImpl.class);
//    @Override
//    public List<PhoneBookEntry> list() {
//        return phoneBookRepository.list();
//    }

    @Override
    public PhoneBookResponse list() {
        try {
            List<PhoneBookEntry> phoneBookEntries = phoneBookEntryRepository.findAll();
            return new PhoneBookResponse("200","success", phoneBookEntries);
        } catch (Exception e) {
            return new PhoneBookResponse("500","Exception occured: {}" + e.getMessage());
        }
    }

    @Override
    public PhoneBookResponse add(PhoneBookEntry phoneBookEntry) {
        String numRegex = "^(?:(?:(\\+(00|011)?[1-9]\\d*[-. ]?)|(0\\d{1,2}[-. ]?))?(1[-. ]?)?(\\(\\d{1,4}\\)|\\d{1,4})?[-. ]?(\\d{3}[-. ]?\\d{4}|\\d{5}|\\d{2}[-. ]?\\d{8}|\\d{1,5}\\.\\d{1,5}))?(\\s?(ext|x|ext\\.)\\s?\\d{1,6})?$";
        String nameRegex = "^[A-Z][a-zA-Z']+([ -][A-Z][a-zA-Z']+)?(?:, [A-Z][a-zA-Z']+((?: [A-Z]\\.)?)?)?$";
        Pattern pName = Pattern.compile(nameRegex);
        Pattern pNumRegex = Pattern.compile(numRegex);
        Matcher mName = pName.matcher(phoneBookEntry.getName());
        Matcher mNumber = pNumRegex.matcher(phoneBookEntry.getPhoneNumber());
        //System.out.println(mName.matches());
        if (!mName.matches()) {
            return new PhoneBookResponse("400","Bad Request, Invalid name");
        }
        if (!mNumber.matches()){
            return new PhoneBookResponse("400","Bad Request, Invalid number");
        }
        try {
            phoneBookEntryRepository.save(phoneBookEntry);
            return new PhoneBookResponse("200","success");
        } catch (Exception e) {
            return new PhoneBookResponse("500","Exception occured: {}" + e.getMessage());
        }
    }

    @Override
    public PhoneBookResponse deleteByName(String name) {
        try {
            phoneBookEntryRepository.deleteByName(name);
            return new PhoneBookResponse("200","success");
        } catch (Exception e) {
            return new PhoneBookResponse("500","Exception occured: {}" + e.getMessage());
        }
        //phoneBookRepository.deleteByName(phoneName);
    }


    @Override
    public PhoneBookResponse deleteByNumber(String phoneNumber) {
        try {
            phoneBookEntryRepository.deleteByPhoneNumber(phoneNumber);
            return new PhoneBookResponse("200","success");
        } catch (Exception e) {
            return new PhoneBookResponse("500","Exception occured: {}" + e.getMessage());
        }
        //phoneBookRepository.deleteByNumber(phoneNumber);
    }
}
