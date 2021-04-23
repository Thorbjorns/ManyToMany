package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tribe")
public class Tribe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "joinedTribes")
    private List<Barbarian> barbarians = new ArrayList<>();

    public Tribe() {
    }

    public Tribe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBarbarian(Barbarian barbarian){
        barbarians.add(barbarian);
    }
}
