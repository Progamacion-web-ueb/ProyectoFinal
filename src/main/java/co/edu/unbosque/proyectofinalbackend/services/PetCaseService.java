package co.edu.unbosque.proyectofinalbackend.services;




import co.edu.unbosque.proyectofinalbackend.jpa.entities.PetCase;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetCaseRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetCasePOJO;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class PetCaseService {

    PetCaseRepository petCaseRepository;


    public PetCasePOJO createPetCase(String case_id, String created_at,String type,String description,String pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petCaseRepository = new PetCaseRepositoryImpl(entityManager);
        Optional<PetCase> petcase = petCaseRepository.save(new PetCase(case_id,created_at,type,description), pet_id);

        entityManager.close();
        entityManagerFactory.close();

        PetCasePOJO petCasePOJO = null;
        if (petcase.isPresent()) {
            petCasePOJO = new PetCasePOJO(
                    petcase.get().getCase_id(),
                    petcase.get().getCreated_at(),
                    petcase.get().getType(),
                    petcase.get().getDescription(),
                    petcase.get().getPet());
        }
        return petCasePOJO;

    }

    public List<PetCasePOJO> listPetCases( ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petCaseRepository = new PetCaseRepositoryImpl(entityManager);
        List<PetCase> petCases = petCaseRepository.findAll();


        entityManager.close();
        entityManagerFactory.close();

        List<PetCasePOJO> petCasesPOJO = new ArrayList<>();

        for (PetCase petcase : petCases) {
            petCasesPOJO.add(new PetCasePOJO(
                    petcase.getCase_id(),
                    petcase.getCreated_at(),
                    petcase.getType(),
                    petcase.getDescription(),
                    petcase.getPet()
                    ));
        }
        return petCasesPOJO;
    }
}
