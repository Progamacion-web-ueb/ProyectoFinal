package co.edu.unbosque.proyectofinalbackend.services;



import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetRepository;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
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


 public List<PetPOJO> listPets(String owner_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        List<Pet> pets = petRepository.findAll();


        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petsPOJO = new ArrayList<>();

        /*
                this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner = owner;
         */

        for (Pet pet : pets) {
            if(owner_id.equals(pet.getOwner().getUsername())){
                petsPOJO.add(new PetPOJO(
                        pet.getPet_id(),
                        pet.getMicrochip(),
                        pet.getName(),
                        pet.getSpecies(),
                        pet.getRace(),
                        pet.getSize(),
                        pet.getSex(),
                        pet.getPicture(),
                        pet.getOwner()));
            }

        }
        return petsPOJO;
    }


}
