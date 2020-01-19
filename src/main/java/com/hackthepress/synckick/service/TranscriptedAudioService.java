package com.hackthepress.synckick.service;

import com.hackthepress.synckick.domain.TranscriptedAudio;
import com.hackthepress.synckick.repository.TranscriptedAudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranscriptedAudioService {

    @Autowired
    private TranscriptedAudioRepository transcriptedAudioRepository;

    public Optional<TranscriptedAudio> findById(String id) {
         return transcriptedAudioRepository.findById(id);
    }

    public List<TranscriptedAudio> findAll() {
        return transcriptedAudioRepository.findAll();
    }

    public void insert(TranscriptedAudio transcriptedAudio) {
        if (transcriptedAudioRepository.findById(transcriptedAudio.getId()).isPresent()) {
            transcriptedAudioRepository.save(transcriptedAudio);
        } else {
            transcriptedAudioRepository.insert(transcriptedAudio);
        }
    }
}
