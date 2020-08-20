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
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String slug;

    @ManyToOne
    private Challenge challenge;

    @Column(nullable = false)
    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "candidatePk.acceleration")
    private List<Candidate> candidates = new ArrayList<>();

}
