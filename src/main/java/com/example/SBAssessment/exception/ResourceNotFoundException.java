package com.example.SBAssessment.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String Message) {
        super(Message);
    }
}
