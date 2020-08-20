package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Eduarda de Brum Lucena
 */
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
public class Submission {

    @EmbeddedId
    private SubmissionPk submissionPk;

    @Column(nullable = false)
    @NotNull
    private Float score;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;
}
