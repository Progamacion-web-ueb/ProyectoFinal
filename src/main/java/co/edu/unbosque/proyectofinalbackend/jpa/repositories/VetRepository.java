package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;

import java.util.Optional;

public interface VetRepository {

    Optional<Vet> save(Vet vet);

    Vet findByVet_id(String Username);
}
