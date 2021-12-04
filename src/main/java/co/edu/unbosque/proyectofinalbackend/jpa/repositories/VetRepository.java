package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    Optional<Vet> save(Vet vet);

    List<Vet> findAll();

    //Vet findByVet_id(String Username);
}
