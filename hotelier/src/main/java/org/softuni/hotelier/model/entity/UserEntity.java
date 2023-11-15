package org.softuni.hotelier.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRoleEntity> roles = new ArrayList<>();

    private String password;

    private String firstName;

    private String lastName;

    private boolean active;

    public String getEmail() {
        return email;
    }
}