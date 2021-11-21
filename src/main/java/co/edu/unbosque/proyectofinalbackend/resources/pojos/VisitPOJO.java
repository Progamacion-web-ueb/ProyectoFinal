package co.edu.unbosque.proyectofinalbackend.resources.pojos;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Visit;

public class VisitPOJO {

    private String visit_id;
    private String created_at;
    private String type;
    private String description;
    private Pet pet_id;
    private Vet vet_id;

    public VisitPOJO() {

    }

    public VisitPOJO(String visit_id, String created_at, String type, String description, Pet pet_id, Vet vet_id) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
        this.vet_id = vet_id;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
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

    public Pet getPet_id() {
        return pet_id;
    }

    public void setPet_id(Pet pet_id) {
        this.pet_id = pet_id;
    }

    public Vet getVet_id() {
        return vet_id;
    }

    public void setVet_id(Vet vet_id) {
        this.vet_id = vet_id;
    }
}
