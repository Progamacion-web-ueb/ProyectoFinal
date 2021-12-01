package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetPOJO;

import java.util.Optional;

public interface PetRepository {

    Optional<Pet> save(Pet pet, String ownerId);

    Pet findByPet_id(String Pet_id);
}
