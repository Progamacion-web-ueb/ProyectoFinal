package co.edu.unbosque.proyectofinalbackend.jpa.repositories;


import co.edu.unbosque.proyectofinalbackend.jpa.entities.PetCase;


import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {
    Optional<PetCase> save(PetCase petCase, String pet_id);
    List<PetCase> findAll();
}
