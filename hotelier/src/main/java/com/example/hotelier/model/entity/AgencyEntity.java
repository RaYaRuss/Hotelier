package com.example.hotelier.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "agencies")
public class AgencyEntity extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "travelAgency")
    private Set<UserEntity> agents;

    public AgencyEntity(String name, Set<UserEntity> agents) {
        this.name = name;
        this.agents = new HashSet<>();
    }

    public AgencyEntity(String name) {
        this.name = name;
    }

    public AgencyEntity() {
        this.agents =  new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getAgents() {
        return agents;
    }

    public void setAgents(Set<UserEntity> agents) {
        this.agents = agents;
    }
}
