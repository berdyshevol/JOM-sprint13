package com.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Progress {
    public enum TaskStatus {
        PASS, FAIL, PENDING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @OneToMany(mappedBy = "progress", cascade =CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "progress", cascade = CascadeType.ALL)
    private List<User> trainees;

    @CreationTimestamp
    private LocalDate started;

    @UpdateTimestamp
    private LocalDate updated;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
