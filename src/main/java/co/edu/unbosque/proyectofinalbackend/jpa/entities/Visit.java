package co.edu.unbosque.proyectofinalbackend.jpa.entities;

import javax.persistence.*;

@Table(name = "visit")
@Entity
public class Visit {

    @Id
    @Column(name = "visit_id")
    private String visit_id;

    @Column(name = "created_at", nullable = false)
    private String created_at;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(name="vet_id", referencedColumnName="username")
    private Vet vet;

    @ManyToOne()
    @JoinColumn(name="pet_id", referencedColumnName="pet_id")
    private Pet pet;

    public Visit() {
    }

    public Visit(String visit_id, String created_at, String type, String description) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
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

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}