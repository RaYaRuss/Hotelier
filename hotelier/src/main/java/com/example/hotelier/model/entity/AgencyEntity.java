package com.example.hotelier.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "agencies")
public class AgencyEntity extends BaseEntity{

    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "travelAgency")
    private List<UserEntity> agents;

    public AgencyEntity(String name, Set<UserEntity> agents) {
        this.name = name;
        this.agents = new ArrayList<>();
    }

    public AgencyEntity(String name) {
        this.name = name;
    }

    public AgencyEntity() {
        this.agents =  new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getAgents() {
        return agents;
    }

    public void setAgents(List<UserEntity> agents) {
        this.agents = agents;
    }
}
