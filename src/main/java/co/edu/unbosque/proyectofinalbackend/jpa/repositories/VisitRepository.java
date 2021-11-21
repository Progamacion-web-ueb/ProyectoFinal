package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Visit;

import java.util.Optional;

public interface VisitRepository {
    Optional<Visit> save(Visit visit);

}
