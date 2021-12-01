package co.edu.unbosque.proyectofinalbackend.jpa.entities;

import javax.persistence.*;

@Table(name = "pet_case")
@Entity
public class PetCase {

    @Id
    @Column(name = "case_id")
    private String case_id;

    @Column(name = "created_at", nullable = false)
    private String created_at;

    @Column(name = "type", nullable = true)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(name="pet_id", referencedColumnName="pet_id")
    private Pet pet;

    public PetCase() {
    }

    public PetCase(String case_id, String created_at, String type, String description) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public String getCase_id() {
        return case_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setType(String type) {
        this.type = type;
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
}