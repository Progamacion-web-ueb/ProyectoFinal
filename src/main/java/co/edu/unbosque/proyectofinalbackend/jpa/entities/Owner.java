package co.edu.unbosque.proyectofinalbackend.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Owner")
@PrimaryKeyJoinColumn
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Owner.findByUsername",
                query = "SELECT a FROM Owner a WHERE a.username = :username")
})
public class Owner extends UserApp {

    @Column(name = "person_id", nullable = false, unique = true)
    private Long personId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pet;

    public Owner() {
    }

    public Owner(String username, String password, String email, Long personId, String name, String address, String neighborhood) {
        super(username, password, email, "owner");
        this.personId = personId;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

}
