package co.edu.unbosque.proyectofinalbackend.services;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Pet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Visit;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.*;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class VisitService {

    VisitRepository visitRepository;
    VetRepository vetRepository;
    PetRepository petRepository;

    public Optional<VisitPOJO> createVisit(VisitPOJO visitPOJO) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);

        Visit visit = new Visit(visitPOJO.getVisit_id(),visitPOJO.getCreated_at(),visitPOJO.getType(),
                visitPOJO.getDescription(),visitPOJO.getPet_id(),visitPOJO.getVet_id());

        Optional<Visit> persistedVisit = visitRepository.save(visit);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVisit.isPresent()) {
            return Optional.of(new VisitPOJO(
                    persistedVisit.get().getVisit_id(),
                    persistedVisit.get().getCreated_at(),
                    persistedVisit.get().getType(),
                    persistedVisit.get().getDescription(),
                    persistedVisit.get().getPet(),
                    persistedVisit.get().getVet()));
        } else {
            return Optional.empty();
        }

    }

    public Vet findVet_id(String vet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet vet= vetRepository.findByVet_id(vet_id);

        entityManager.close();
        entityManagerFactory.close();

        return vet;

    }
    public Pet findPet_id(String pet_id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        Pet pet= petRepository.findByPet_id(pet_id);


        entityManager.close();
        entityManagerFactory.close();

        return pet;
    }

}
