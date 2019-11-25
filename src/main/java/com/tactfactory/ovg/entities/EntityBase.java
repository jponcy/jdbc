package com.tactfactory.ovg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@MappedSuperclass
public class EntityBase {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty(access = Access.READ_ONLY)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime updatedAt;

    protected EntityBase() {}

//    @PrePersist
//    public void updateCreatedAt() {
//        this.createdAt = LocalDateTime.now();
//    }
//
//    @PrePersist
//    @PreUpdate
//    public void updateUpdatedAt() {
//        this.updatedAt = LocalDateTime.now();
//    }

    @PrePersist
    public void prePersist() {
        final LocalDateTime now = LocalDateTime.now();

        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
}
