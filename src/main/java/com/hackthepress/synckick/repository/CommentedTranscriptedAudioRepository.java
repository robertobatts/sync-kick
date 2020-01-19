package com.hackthepress.synckick.repository;

import com.hackthepress.synckick.domain.CommentedTranscriptedAudio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentedTranscriptedAudioRepository extends MongoRepository<CommentedTranscriptedAudio, String> {
}
