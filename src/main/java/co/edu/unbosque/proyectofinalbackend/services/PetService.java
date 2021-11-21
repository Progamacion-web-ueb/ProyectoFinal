package co.edu.unbosque.proyectofinalbackend.services;


import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OwnerRepository;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetRepository;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class PetService {

    PetRepository petRepository;
    OwnerRepository ownerRepository;

    public Optional<PetPOJO> createPet(PetPOJO petPOJO) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);

        Pet pet = new Pet(petPOJO.getPet_id(),petPOJO.getMicrochip(),petPOJO.getName(),petPOJO.getSpecies(),petPOJO.getRace()
                       ,petPOJO.getSize(),petPOJO.getSize(),petPOJO.getPicture(),petPOJO.getOwner_id());
        Optional<Pet> persistedPet = petRepository.save(pet);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedPet.isPresent()) {
            return Optional.of(new PetPOJO(
                    persistedPet.get().getPet_id(),
                    persistedPet.get().getMicrochip(),
                    persistedPet.get().getName(),
                    persistedPet.get().getSpecies(),
                    persistedPet.get().getRace(),
                    persistedPet.get().getSize(),
                    persistedPet.get().getSex(),
                    persistedPet.get().getPicture(),
                    persistedPet.get().getOwner()
            ));

        } else {
            return Optional.empty();
        }
    }
    public Owner findOwner_id(String owner_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner owner= ownerRepository.findByUsername(owner_id);

        entityManager.close();
        entityManagerFactory.close();

        return owner;

    }

}
