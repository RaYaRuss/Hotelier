package com.example.hotelier.model.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "agencies")
public class AgencyEntity extends BaseEntity{

    private String name;

    @OneToMany
    private Set<UserEntity> agents;

}
