package com.example.SBAssignment.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private int status;
    private String Message;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, LocalDateTime timestamp) {
        this.status = status;
        Message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return Message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
