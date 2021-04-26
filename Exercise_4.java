package com.company;

public class Main {

    public static void main(String[] args){

        String myStr = null;

        countChar(myStr); //NullPointerException
    }

    static int countChar(String s){
        try {
            return s.length();
        } catch (NullPointerException ex){
            System.out.println("Exception thrown  :" + ex);
        }
        return 0;
    }
}
