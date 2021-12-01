package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;

import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> save(Owner owner);

  //  Owner findByUsername(String Username);
}
