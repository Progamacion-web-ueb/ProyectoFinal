package co.edu.unbosque.proyectofinalbackend.jpa.entities;

import javax.persistence.*;

@Table(name = "official")
@Entity
@PrimaryKeyJoinColumn
@NamedQueries({
        @NamedQuery(name = "Official.findByUsername",
                query = "SELECT a FROM Official a WHERE a.username = :username"),
        @NamedQuery(name = "Official.update",
                query = "UPDATE Official AS c  SET c.name=:name")
})

public class Official extends UserApp {

    @Column(name = "name", nullable = false)
    private String name;

    public Official() {
    }

    public Official(String username, String password, String email,  String name) {
        super(username, password, email, "official");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}