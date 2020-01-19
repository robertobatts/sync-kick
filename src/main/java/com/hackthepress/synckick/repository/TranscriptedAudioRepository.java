package com.hackthepress.synckick.repository;

import com.hackthepress.synckick.domain.TranscriptedAudio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptedAudioRepository extends MongoRepository<TranscriptedAudio, String> {
}
