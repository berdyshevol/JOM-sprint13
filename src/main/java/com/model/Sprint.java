package com.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="sprint")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate finish;

    @Column(columnDefinition = "DATE")
    private LocalDate start;

    @NotNull
    private String title;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marathon_id", referencedColumnName = "id")
    private Marathon marathon;
}
