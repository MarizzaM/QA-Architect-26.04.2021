package com.company;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
public class CellphoneTest {

    @Test
    public void addPhoneNumberToList_positive_flow() throws InvalidNumberException, PhoneBookIsFullException {
        Cellphone cellphone = new Cellphone();

        String myPhoneNumber = "052650394";

        cellphone.addPhoneNumberToList(myPhoneNumber);

        assertEquals(myPhoneNumber, cellphone.m_phoneBook.get(0));
    }

    @Test (expected = InvalidNumberException.class)
    public void addPhoneNumberToList_InvalidNumberException() throws InvalidNumberException, PhoneBookIsFullException {
        Cellphone cellphone = new Cellphone();

        String myPhoneNumber = null;

        cellphone.addPhoneNumberToList(myPhoneNumber);
    }

    @Test (expected = PhoneBookIsFullException.class)
    public void addPhoneNumberToList_PhoneBookIsFullException() throws InvalidNumberException, PhoneBookIsFullException {
        Cellphone cellphone = new Cellphone();

        for (int i = 1; i <= 10; i++){
            cellphone.m_phoneBook.add("0526503344");
        }
        cellphone.addPhoneNumberToList("0528945678");
    }

    @Test (expected = InvalidNumberException.class)
    public void callNumber_InvalidNumberException() throws InvalidNumberException, PhoneBookIsFullException {
        Cellphone cellphone = new Cellphone();

        String myPhoneNumber = null;

        cellphone.callNumber(myPhoneNumber);
    }




}
