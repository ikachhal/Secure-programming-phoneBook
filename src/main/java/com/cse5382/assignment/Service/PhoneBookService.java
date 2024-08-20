package com.cse5382.assignment.Service;

import com.cse5382.assignment.Model.PhoneBookEntry;
import com.cse5382.assignment.Model.PhoneBookResponse;

import java.util.List;

public interface PhoneBookService {
    public PhoneBookResponse list();

    public PhoneBookResponse add(PhoneBookEntry phoneBookEntry);

    public PhoneBookResponse deleteByName(String name);

    public PhoneBookResponse deleteByNumber(String phoneNumber);
}
