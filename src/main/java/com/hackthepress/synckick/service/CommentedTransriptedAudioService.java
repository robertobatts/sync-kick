package com.hackthepress.podclub.service;

import com.hackthepress.podclub.domain.Comment;
import com.hackthepress.podclub.domain.CommentedTranscriptedAudio;
import com.hackthepress.podclub.repository.CommentedTranscriptedAudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CommentedTransriptedAudioService {

    @Autowired
    private CommentedTranscriptedAudioRepository commentedTranscriptedAudioRepository;

    public Optional<CommentedTranscriptedAudio> findById(String id) {
        return commentedTranscriptedAudioRepository.findById(id);
    }

    public void addComment(String audioId, int wordNumber, String user, String commentMsg) {
        Comment comment = new Comment(user, commentMsg, LocalDateTime.now());
        Optional<CommentedTranscriptedAudio> commentedTranscriptedAudioOpt = commentedTranscriptedAudioRepository.findById(audioId);
        if (commentedTranscriptedAudioOpt.isPresent()) {
            CommentedTranscriptedAudio commentedTranscriptedAudio = commentedTranscriptedAudioOpt.get();
            commentedTranscriptedAudio.insertCommentForWordNumber(wordNumber, comment);
            commentedTranscriptedAudioRepository.save(commentedTranscriptedAudio);
        } else {
            CommentedTranscriptedAudio commentedTranscriptedAudio = new CommentedTranscriptedAudio(
                    audioId, new HashMap<>()
            );
            commentedTranscriptedAudio.insertCommentForWordNumber(wordNumber, comment);
            commentedTranscriptedAudioRepository.insert(commentedTranscriptedAudio);
        }
    }
}
