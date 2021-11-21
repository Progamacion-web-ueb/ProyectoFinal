package co.edu.unbosque.proyectofinalbackend.services;


import co.edu.unbosque.proyectofinalbackend.jpa.entities.PetCase;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetCaseRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.PetCasePOJO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class PetCaseService {

    PetCaseRepository petCaseRepository;

    public Optional<PetCasePOJO> createPetCase(PetCasePOJO petCasePOJO) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petCaseRepository = new PetCaseRepositoryImpl(entityManager);

        PetCase petCase = new PetCase(petCasePOJO.getCase_id(),petCasePOJO.getCreated_at(),petCasePOJO.getType()
                                        ,petCasePOJO.getDescription(),petCasePOJO.getPet_id());

        Optional<PetCase> persistedPetCase = petCaseRepository.save(petCase);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedPetCase.isPresent()) {
            return Optional.of(new PetCasePOJO(
                    persistedPetCase.get().getCase_id(),
                    persistedPetCase.get().getCreated_at(),
                    persistedPetCase.get().getType(),
                    persistedPetCase.get().getDescription(),
                    persistedPetCase.get().getPet()));
        } else {
            return Optional.empty();
        }

    }
}
