package com.demo.example.NoteTakingBackend.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
/**
 * above jsonignoreproperties is added why??
 * is a common Hibernate + Jackson issue. It happens when you return an entity that is lazily loaded, 
 * and Jackson tries to serialize a proxy object (ByteBuddyInterceptor is part of Hibernate’s lazy-loading mechanism).
🔍 Root Cause:
Jackson (used by Spring Boot to serialize responses to JSON) can't handle Hibernate's proxy objects unless told how to do so. 
Your entity (Notes) is likely being lazily loaded, and when it gets returned in a controller, Jackson tries to serialize the proxy, but fails.
 */
public class Notes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(name = "subject_line")
    private String subjectLine;
    private String body;

	@Column(name = "created_at")
    private LocalDateTime createdAt;

	@Column(name = "created_by")
    private String createdBy;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Getters and Setters below

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSubjectLine() { return subjectLine; }
    public void setSubjectLine(String subjectLine) { this.subjectLine = subjectLine; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	
	
	

}
