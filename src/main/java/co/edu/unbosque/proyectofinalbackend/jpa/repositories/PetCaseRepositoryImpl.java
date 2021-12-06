package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.PetCase;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetCaseRepositoryImpl implements PetCaseRepository{

    private EntityManager entityManager ;

    public PetCaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<PetCase> save(PetCase petCase,String pet_id) {
        try {
            entityManager.getTransaction().begin();

            Pet pet =  entityManager.find(Pet.class ,pet_id);
            petCase.setPet(pet);
            System.out.println("Movie returned: " + pet.getPet_id());

            entityManager.persist(petCase);
            entityManager.getTransaction().commit();
            return Optional.of(petCase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<PetCase> findAll() {
        return entityManager.createQuery("from PetCase ").getResultList();
    }
}
