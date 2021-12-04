package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;


import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    Optional<Official> save(Official official);

    Official Update(String Username,String name);

    List<Official> findAll();
}
