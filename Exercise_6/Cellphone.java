package com.company;

import java.util.ArrayList;

public class Cellphone {
    public ArrayList<String> m_phoneBook = new ArrayList<>();

    public void addPhoneNumberToList (String phoneNumber) throws InvalidNumberException, PhoneBookIsFullException {
        if (phoneNumber == null){
            throw new InvalidNumberException("The input format is incorrect");
        }
        if (m_phoneBook.size() >= 10){
            throw new PhoneBookIsFullException("The phone book is full");
        }
        m_phoneBook.add(0,phoneNumber);
    }

    public void callNumber(String phoneNumber) throws InvalidNumberException {
        if (phoneNumber == null){
            throw new InvalidNumberException("The input format is incorrect");
        }
        System.out.println("Calling... " + phoneNumber);
    }
}
