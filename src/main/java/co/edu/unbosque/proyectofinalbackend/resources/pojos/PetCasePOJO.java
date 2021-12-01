package co.edu.unbosque.proyectofinalbackend.resources.pojos;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;

public class PetCasePOJO {

    private String case_id;
    private String created_at;
    private String type;
    private String description;
    private Pet pet;
    private String pet_id;

    public PetCasePOJO() {
    }

    public PetCasePOJO(String case_id, String created_at, String type, String description, Pet pet) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet = pet;
    }

    public PetCasePOJO(String case_id, String created_at, String type, String description, String pet_id) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
    }

    public String getCase_id() {
        return case_id;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }
}
