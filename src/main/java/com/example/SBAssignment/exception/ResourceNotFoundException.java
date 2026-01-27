package com.example.SBAssignment.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String Message) {
        super(Message);
    }
}
