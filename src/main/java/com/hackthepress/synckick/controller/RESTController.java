package com.hackthepress.synckick.controller;

import com.hackthepress.synckick.domain.CommentedTranscriptedAudio;
import com.hackthepress.synckick.domain.PostCommentRequest;
import com.hackthepress.synckick.domain.TranscriptedAudio;
import com.hackthepress.synckick.service.CommentedTransriptedAudioService;
import com.hackthepress.synckick.service.TranscriptedAudioService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
public class RESTController {

    @Autowired
    private TranscriptedAudioService transcriptedAudioService;

    @Autowired
    private CommentedTransriptedAudioService commentedTransriptedAudioService;

    @GetMapping(
            value = "/get-podcast-raw",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public @ResponseBody byte[] getPodcastRaw(@RequestParam String id) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/audiofiles/" + id + ".mp3");
        return IOUtils.toByteArray(in);
    }

    @GetMapping("/get-transcriptedaudio")
    public ResponseEntity getTranscriptAudio(@RequestParam (required = false) String id) {
        if (id != null && !id.isEmpty()) {
            Optional<TranscriptedAudio> transcriptedAudio = transcriptedAudioService.findById(id);
            if (transcriptedAudio.isPresent()) {
                return ResponseEntity.ok(transcriptedAudio.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<TranscriptedAudio> transcriptedAudioList = transcriptedAudioService.findAll();
            if (!transcriptedAudioList.isEmpty()) {
                return ResponseEntity.ok(transcriptedAudioList);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @PostMapping("/post-transcriptedaudio")
    public ResponseEntity postTranscriptedAudio(@RequestBody TranscriptedAudio transcriptedAudio) {
        transcriptedAudioService.insert(transcriptedAudio);
        return ResponseEntity.ok().build();
    }

    @GetMapping("get-comments")
    public ResponseEntity getComments(@RequestParam String id) {
        Optional<CommentedTranscriptedAudio> commentedTranscriptedAudio = commentedTransriptedAudioService.findById(id);
        if (commentedTranscriptedAudio.isPresent()) {
            return ResponseEntity.ok(commentedTranscriptedAudio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post-comment")
    public ResponseEntity postComment(@RequestBody PostCommentRequest postCommentRequest) {
        commentedTransriptedAudioService.addComment(
                postCommentRequest.getAudioId(),
                postCommentRequest.getWordNumber(),
                postCommentRequest.getUser(),
                postCommentRequest.getComment()
        );
        return ResponseEntity.ok().build();
    }
}