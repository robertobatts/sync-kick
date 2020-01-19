package com.hackthepress.synckick.domain;

import java.time.LocalDateTime;

public class Comment {
    private String user;
    private String comment;
    private LocalDateTime createdDateTime;

    public Comment(String user, String comment, LocalDateTime createdDateTime) {
        this.user = user;
        this.comment = comment;
        this.createdDateTime = createdDateTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
