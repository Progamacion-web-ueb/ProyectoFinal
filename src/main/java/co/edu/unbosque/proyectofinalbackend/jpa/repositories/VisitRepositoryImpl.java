package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitRepositoryImpl implements VisitRepository{

    private EntityManager entityManager;

    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Visit> save(Visit visit, String pet_id,String visit_id) {
        try {
            entityManager.getTransaction().begin();

            Pet pet =  entityManager.find(Pet.class ,pet_id);
            visit.setPet(pet);
            System.out.println("Movie returned: " + pet.getPet_id());

            Vet vet =  entityManager.find(Vet.class ,visit_id);
            visit.setVet(vet);
            System.out.println("Movie returned: " + vet.getUsername());

            entityManager.persist(visit);
            entityManager.getTransaction().commit();

            return Optional.of(visit);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit ").getResultList();
    }
}
