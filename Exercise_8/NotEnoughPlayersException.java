package com.company;

public class NotEnoughPlayersException extends Exception{
    public NotEnoughPlayersException(String message) {
        super(message);
    }
}
