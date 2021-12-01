package co.edu.unbosque.proyectofinalbackend.jpa.repositories;


import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.Optional;

public class VetRepositoryImpl implements VetRepository {

    private EntityManager entityManager;

    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Vet> save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
/*
    @Override
    public Vet findByVet_id(String username) {
        Vet vet = (Vet) entityManager.createNamedQuery("Vet.findByUsername",Vet.class)
                .setParameter("username", username)
                .getSingleResult();
        return vet ;
    }
*/
}
