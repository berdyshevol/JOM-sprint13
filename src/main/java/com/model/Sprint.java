package com.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UpdateTimestamp
    private LocalDate startDate;

    @UpdateTimestamp // TODO: is it right?
    private LocalDate finish;

    @NotNull
    private String title;

    @ToString.Exclude
    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ToString.Exclude
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "marathon_id")
    Marathon marathon;
}
