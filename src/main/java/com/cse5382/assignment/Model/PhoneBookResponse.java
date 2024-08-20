package com.cse5382.assignment.Model;

import lombok.Data;

@Data
public class PhoneBookResponse {
    String code;
    String description;
    Object content;

    public PhoneBookResponse(String code, String description) {
        this.code = code;
        this.description = description;
        this.content = null;
    }

    public PhoneBookResponse(String code, String description, Object content) {
        this.code = code;
        this.description = description;
        this.content = content;
    }
}
