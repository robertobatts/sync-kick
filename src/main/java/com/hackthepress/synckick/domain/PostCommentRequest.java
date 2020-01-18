package com.hackthepress.podclub.domain;

public class PostCommentRequest {
    private String audioId;
    private int wordNumber;
    private String comment;
    private String user;

    public PostCommentRequest(String audioId, int wordNumber, String comment, String user) {
        this.audioId = audioId;
        this.wordNumber = wordNumber;
        this.comment = comment;
        this.user = user;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    public int getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(int wordNumber) {
        this.wordNumber = wordNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
