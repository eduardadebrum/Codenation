package com.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    private String slug;

    @Column(nullable = false)
    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "candidatePk.company")
    private List<Candidate> candidates = new ArrayList<>();
}
