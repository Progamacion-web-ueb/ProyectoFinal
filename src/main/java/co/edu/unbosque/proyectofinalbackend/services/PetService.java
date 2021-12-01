package co.edu.unbosque.proyectofinalbackend.services;



import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
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

    public PetPOJO createPet(String pet_id, Long microchip,String name,String species,
                             String race,String size,String sex,String picture,String ownerId)
    {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        Optional<Pet> pet =  petRepository.save(new Pet(pet_id,microchip, name, species, race, size, sex, picture),ownerId );


        entityManager.close();
        entityManagerFactory.close();

        PetPOJO petPOJO = null;
        if (pet.isPresent()) {
            petPOJO = new PetPOJO(
                    pet.get().getPet_id(),
                    pet.get().getMicrochip(),
                    pet.get().getName(),
                    pet.get().getSpecies(),
                    pet.get().getRace(),
                    pet.get().getSize(),
                    pet.get().getSex(),
                    pet.get().getPicture(),
                    pet.get().getOwner());

        }
            return petPOJO;
    }
    /*
    public Owner findOwner_id(String owner_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner owner= ownerRepository.findByUsername(owner_id);

        entityManager.close();
        entityManagerFactory.close();

        return owner;

    }
*/
}
