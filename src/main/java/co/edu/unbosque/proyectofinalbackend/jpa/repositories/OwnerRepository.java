package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> save(Owner owner);

    List<Owner> findAll();

  //  Owner findByUsername(String Username);
}
