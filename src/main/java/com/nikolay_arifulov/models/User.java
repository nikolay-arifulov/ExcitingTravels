package com.nikolay_arifulov.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {

    public enum Role {
        USER, ADMIN
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    private String hashPassword;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    private LocalDate dateOfBirth;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "traveller")
    private Set<Travel> travels;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "friends")
    private Set<User> befriended;
}
