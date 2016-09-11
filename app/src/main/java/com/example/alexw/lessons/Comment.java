package com.example.alexw.lessons;


public class Comment {
    private String message;
    private String authorEmail;
    private String objectId;

    public Comment() {
    }

    public Comment(String message, String authorEmail) {
        this.message = message;
        this.authorEmail = authorEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId( String objectId ) {
        this.objectId = objectId;
    }







}