package co.edu.unbosque.proyectofinalbackend.jpa.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Table(name = "pet")
@Entity

public class Pet  {

    @Id
    @Column(name = "pet_id", nullable = false)
    private String pet_id;

    @Column(name = "microchip", nullable = true, unique = true)
    private Long microchip;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "picture", nullable = true)
    private String picture;

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "username")
    private Owner owner;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<PetCase> pet_case;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.JOIN)
    private List<Visit> Visit;

    public Pet() {
    }

    public Pet(String pet_id) {
        this.pet_id = pet_id;
    }

    public Pet(String pet_id, Long microchip, String name, String species, String race, String size, String sex, String picture) {
        this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }

    public Long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}