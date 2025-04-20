package com.example.demo.models;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;


@Document(collection = "rating")
public class Rating {
    @Id
    private String id = UUID.randomUUID().toString();
    private Long entityId;
    private String entityType;
    private int score;
    private String comment;
    private LocalDateTime timestamp = LocalDateTime.now();

    public Rating() {
    }

    public Rating(String entityType, Long entityId, int score, String comment, LocalDateTime timestamp) {
        this.entityType = entityType;
        this.entityId = entityId;
        this.score = score;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
