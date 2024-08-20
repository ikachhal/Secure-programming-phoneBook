package com.cse5382.assignment;

import com.cse5382.assignment.Model.PhoneBookEntry;
import com.cse5382.assignment.Model.PhoneBookResponse;
import com.cse5382.assignment.Repository.PhoneBookEntryRepository;
import com.cse5382.assignment.Service.PhoneBookService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;


//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = AssignmentApplication.class)
class AssignmentApplicationTests {

    @Autowired
    PhoneBookService phoneBookService;

    @Mock
    PhoneBookEntryRepository phoneBookEntryRepository;

    @InjectMocks
    private AssignmentApplicationTests assignmentApplicationTests;

//    @Test
//    public void whenValidInput_thenAccept() {
//        List<PhoneBookEntry> phoneBookEntryList = getAcceptablePhoneBookEntries();
//        when(phoneBookEntryRepository.save(any())).thenReturn(null);
//        for(PhoneBookEntry phoneBookEntry: phoneBookEntryList) {
//            PhoneBookResponse phoneBookResponse = phoneBookService.add(phoneBookEntry);
//            assertNotEquals("400", phoneBookResponse.getCode());
//        }
//    }
//
//    @Test
//    public void whenInValidInput_thenReject() {
//        List<PhoneBookEntry> phoneBookEntryList = getUnAcceptablePhoneBookEntries();
//        when(phoneBookEntryRepository.save(any())).thenReturn(null);
//        for(PhoneBookEntry phoneBookEntry: phoneBookEntryList) {
//            PhoneBookResponse phoneBookResponse = phoneBookService.add(phoneBookEntry);
//            assertNotEquals("200", phoneBookResponse.getCode());
//        }
//    }
//
//    @Test
//    public void whenStudentValidInput_thenAccept() {
//        List<PhoneBookEntry> phoneBookEntryList = getStudentPhoneBookEntriesPositive();
//        when(phoneBookEntryRepository.save(any())).thenReturn(null);
//        for(PhoneBookEntry phoneBookEntry: phoneBookEntryList) {
//            PhoneBookResponse phoneBookResponse = phoneBookService.add(phoneBookEntry);
//            assertNotEquals("400", phoneBookResponse.getCode());
//        }
//    }
//
//    @Test
//    public void whenStudentInValidInput_thenAccept() {
//        List<PhoneBookEntry> phoneBookEntryList = getStudentPhoneBookEntriesNegative();
//        when(phoneBookEntryRepository.save(any())).thenReturn(null);
//        for(PhoneBookEntry phoneBookEntry: phoneBookEntryList) {
//            PhoneBookResponse phoneBookResponse = phoneBookService.add(phoneBookEntry);
//            assertNotEquals("200", phoneBookResponse.getCode());
//        }
//    }

    List<PhoneBookEntry> getAcceptablePhoneBookEntries() {
        List<PhoneBookEntry> phoneBookEntries = new ArrayList<>();
        phoneBookEntries.add(new PhoneBookEntry("Bruce Schneier", "12345"));
        phoneBookEntries.add(new PhoneBookEntry("Schneier, Bruce", "12345"));
//        phoneBookEntries.add(new PhoneBookEntry("Schneier, Bruce Wayne", "12345"));
//        phoneBookEntries.add(new PhoneBookEntry("O’Malley, John F.", "12345"));
//        phoneBookEntries.add(new PhoneBookEntry("John O’Malley-Smith", "12345"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "(703)111-2121"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "+1(703)111-2121"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "+32 (21) 212-2324"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "1(703)123-1234"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "011 701 111 1234"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "12345.12345"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "011 1 703 111 1234"));
        return phoneBookEntries;
    }

    List<PhoneBookEntry> getUnAcceptablePhoneBookEntries() {
        List<PhoneBookEntry> phoneBookEntries = new ArrayList<>();
        phoneBookEntries.add(new PhoneBookEntry("Ron O’’Henry", "12345"));
        phoneBookEntries.add(new PhoneBookEntry("Ron O’Henry-Smith-Barnes", "12345"));
        phoneBookEntries.add(new PhoneBookEntry("L33t Hacker", "12345"));
        phoneBookEntries.add(new PhoneBookEntry("<Script>alert(“XSS”)</Script>", "12345"));
        phoneBookEntries.add(new PhoneBookEntry("select * from users;", "12345"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "123"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "1/703/123/1234"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "Nr 102-123-1234"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "<script>alert(“XSS”)</script>"));
        //phoneBookEntries.add(new PhoneBookEntry("Cher", "7031111234"));
        //phoneBookEntries.add(new PhoneBookEntry("Cher", "+1234 (201) 123-1234"));
        //phoneBookEntries.add(new PhoneBookEntry("Cher", "(001) 123-1234"));
        phoneBookEntries.add(new PhoneBookEntry("Cher", "+01 (703) 123-1234"));
        //phoneBookEntries.add(new PhoneBookEntry("Cher", "(703) 123-1234 ext 204"));
        return phoneBookEntries;
    }

    List<PhoneBookEntry> getStudentPhoneBookEntriesPositive() {
        List<PhoneBookEntry> phoneBookEntries = new ArrayList<>();
        phoneBookEntries.add(new PhoneBookEntry("Bruce Schneier", "12345"));
        return phoneBookEntries;
    }

    List<PhoneBookEntry> getStudentPhoneBookEntriesNegative() {
        List<PhoneBookEntry> phoneBookEntries = new ArrayList<>();
        phoneBookEntries.add(new PhoneBookEntry("Ron O’’Henry", "12345"));
        return phoneBookEntries;
    }
}
