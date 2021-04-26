package com.company;

public class PhoneBookIsFullException extends Exception{
    public PhoneBookIsFullException(String message) {
        super(message);
    }
}
