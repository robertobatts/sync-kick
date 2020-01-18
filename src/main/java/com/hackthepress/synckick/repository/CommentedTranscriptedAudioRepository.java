package com.hackthepress.podclub.repository;

import com.hackthepress.podclub.domain.CommentedTranscriptedAudio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentedTranscriptedAudioRepository extends MongoRepository<CommentedTranscriptedAudio, String> {
}
