package com.hackthepress.synckick.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transcripted_audio")
public class TranscriptedAudio {
    @Id
    private String id;
    private String title;
    private String artist;
    private String description;
    private String category;
    private String transcription;
    private String downloadUrl;
    private String pictureUrl;

    public TranscriptedAudio(String id, String title, String artist, String description, String category,
                             String transcription, String downloadUrl, String pictureUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.description = description;
        this.category = category;
        this.transcription = transcription;
        this.downloadUrl = downloadUrl;
        this.pictureUrl = pictureUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
