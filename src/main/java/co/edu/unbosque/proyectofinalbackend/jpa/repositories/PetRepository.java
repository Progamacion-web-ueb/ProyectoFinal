package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetPOJO;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Optional<Pet> save(Pet pet, String ownerId);

    List<Pet> findAll();
}
