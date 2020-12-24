package com.github.ignacioalbornoz.finalreality.controller.gamephases;

public class InvalidTransitionException extends Exception {
    public InvalidTransitionException(String message){
        super(message);
    }
}
