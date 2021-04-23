package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Barbarian")
public class Barbarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String weapon;
    @ManyToMany
    @JoinTable(
            name = "joined_tribes",
    joinColumns = @JoinColumn(name = "barbarian_id"),
    inverseJoinColumns = @JoinColumn(name = "tribe_id"))
    private List<Tribe> joinedTribes = new ArrayList<>();

    public Barbarian() {
    }

    public Barbarian(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void joinTribe(Tribe tribe){
        joinedTribes.add(tribe);
    }
}
