package com.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @ToString.Exclude
    @ManyToMany
    @JoinTable (name = "marathon_user",
        joinColumns = @JoinColumn (name="marathon_id"),
        inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> users;

    @ToString.Exclude
    @OneToMany(mappedBy = "marathon", cascade = CascadeType.ALL)
    private List<Sprint> sprints;
}
