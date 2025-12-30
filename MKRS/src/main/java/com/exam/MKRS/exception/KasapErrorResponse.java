package com.exam.MKRS.exception;

public class KasapErrorResponse {
    private int status;
    private String message;
    private long timestamp;
    public KasapErrorResponse(){}

public KasapErrorResponse(int status,String message, long timestamp){
    this.message=message;
    this.status=status;
    this.timestamp = timestamp;
}
  public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
     @Override
    public String toString() {
        return "StudentErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
    }
}