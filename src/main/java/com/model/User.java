package com.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity(name="users")
public class User {
    public enum Role {
        MENTOR, TRAINEE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 charecters")
    private String lastName;

    @Column(unique = true)
    @NotNull
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    private String password;

    @ToString.Exclude
//    @ManyToMany(mappedBy = "users")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "marathon_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "marathon_id"))
    private List<Marathon> marathons;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="trainee_id")
    private Progress progress;



}

