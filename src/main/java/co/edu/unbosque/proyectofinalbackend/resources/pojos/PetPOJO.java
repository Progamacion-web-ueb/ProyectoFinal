package co.edu.unbosque.proyectofinalbackend.resources.pojos;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;

public class PetPOJO {

    private String pet_id;

    private Long microchip;

    private String name;

    private String species;

    private String race;

    private String size;

    private String sex;

    private String picture;

    private Owner owner;

    private String owner_id;

    public PetPOJO() {
    }

    public PetPOJO(String pet_id, Long microchip, String name, String species,
                   String race, String size, String sex, String picture, String owner_id) {
        this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner_id = owner_id;
    }

    public PetPOJO(String pet_id, Long microchip, String name, String species,
                   String race, String size, String sex, String picture, Owner owner) {
        this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner = owner;
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

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "PetPOJO{" +
                "pet_id='" + pet_id + '\'' +
                ", microchip=" + microchip +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", size='" + size + '\'' +
                ", sex='" + sex + '\'' +
                ", picture='" + picture + '\'' +
                ", owner_id=" + owner_id +
                '}';
    }
}
