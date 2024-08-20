package com.cse5382.assignment.Controller;

import com.cse5382.assignment.Model.PhoneBookEntry;
import com.cse5382.assignment.Model.PhoneBookResponse;
import com.cse5382.assignment.Service.PhoneBookService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    PhoneBookService phoneBookService;

    private static Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping(path = "phoneBook/list")
    public PhoneBookResponse list(){
        logger.info("Request enter: phonebook/list");
        return phoneBookService.list();
    }

    @PostMapping(path = "phoneBook/add")
    public PhoneBookResponse add(@RequestBody PhoneBookEntry phoneBookEntry) {
        logger.info("Request enter: phonebook/add");
//        try {
//            PhoneBookResponse phoneBookResponse = phoneBookService.add(phoneBookEntry);
//        }catch(Exception e){
//            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
//        }
        return phoneBookService.add(phoneBookEntry);
    }

    @PutMapping(path = "phoneBook/deleteByName")
    public PhoneBookResponse deleteByName(@RequestParam String name){
        logger.info("Request enter: phonebook/deleteByName");
//        try {
//            return phoneBookService.deleteByName(name);
//        }catch(Exception e){
//            return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
        return phoneBookService.deleteByName(name);
    }

    @PutMapping(path = "phoneBook/deleteByNumber")
    public PhoneBookResponse deleteByNumber(@RequestParam String number){
        logger.info("Request enter: phonebook/deleteByNumber");
//        try {
//            phoneBookService.deleteByNumber(number);
//        }catch(Exception e){
//            return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
        return phoneBookService.deleteByNumber(number);
    }

}
