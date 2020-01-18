package com.hackthepress.podclub.repository;

import com.hackthepress.podclub.domain.TranscriptedAudio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptedAudioRepository extends MongoRepository<TranscriptedAudio, String> {
}
