package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetRepositoryImpl implements PetRepository{

    private EntityManager entityManager;

    public PetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Pet> save(Pet pet, String ownerId) {
        try {
            entityManager.getTransaction().begin();

            Owner owner = entityManager.find(Owner.class, ownerId);
            pet.setOwner(owner);
            System.out.println("Movie returned: " + owner.getUsername());

            entityManager.persist(pet);
            entityManager.getTransaction().commit();

            return Optional.of(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Pet> findAll() {
         return entityManager.createQuery("from Pet ").getResultList();
    }


}
