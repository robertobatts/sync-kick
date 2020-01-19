package com.hackthepress.synckick.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document( collection = "commented_transcripted_audio")
public class CommentedTranscriptedAudio {
    @Id
    private String id;
    private Map<Integer, List<Comment>> comments;

    public CommentedTranscriptedAudio(String id, Map<Integer, List<Comment>> comments) {
        this.id = id;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, List<Comment>> getComments() {
        return comments;
    }

    public void setComments(Map<Integer, List<Comment>> comments) {
        this.comments = comments;
    }

    public List<Comment> findAllCommentsByWordNumber(int wordNumber) {
        List<Comment> commentsForWord = comments.get(wordNumber);
        if (commentsForWord == null || commentsForWord.isEmpty()) {
            commentsForWord = new ArrayList<>();
        }
        return commentsForWord;
    }

    public void insertCommentForWordNumber(int wordNumber, Comment comment) {
        List<Comment> commentsList = findAllCommentsByWordNumber(wordNumber);
        commentsList.add(comment);
        comments.put(wordNumber, commentsList);
    }
}
