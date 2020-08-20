package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    private String fullName;

    @Column(nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @Column(nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    private String nickname;

    @Column(nullable = false)
    @NotNull
    @Size(max = 255)
    private String password;

    @Column(nullable = false)
    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "submissionPk.user")
    private List<Submission> submissions = new ArrayList<>();

    @OneToMany(mappedBy = "candidatePk.user")
    private List<Candidate> candidates = new ArrayList<>();

}
