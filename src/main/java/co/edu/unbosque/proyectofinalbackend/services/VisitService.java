package co.edu.unbosque.proyectofinalbackend.services;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Visit;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.*;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class VisitService {

    VisitRepository visitRepository;


    public List<VisitPOJO> listVisits() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl (entityManager);
        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitsPOJO = new ArrayList<>();
        for (Visit visit : visits) {
                visitsPOJO.add(new VisitPOJO(
                        visit.getVisit_id(),
                        visit.getCreated_at(),
                        visit.getType(),
                        visit.getDescription(),
                        visit.getPet(),
                        visit.getVet()));
        }
        return visitsPOJO;
    }

    public List<VisitPOJO> listVisitsByVet(String vet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl (entityManager);
        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitsPOJO = new ArrayList<>();
        for (Visit visit : visits) {
            System.out.println("printtttttttttt"+vet_id);
            System.out.println("printtttttttttt"+visit.getVet().getUsername());
            if(vet_id.equals(visit.getVet().getUsername())){
                visitsPOJO.add(new VisitPOJO(
                        visit.getVisit_id(),
                        visit.getCreated_at(),
                        visit.getType(),
                        visit.getDescription(),
                        visit.getPet(),
                        visit.getVet()));
            }
        }
        return visitsPOJO;
    }

    public List<VisitPOJO> listVisitsByPet(String pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl (entityManager);
        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitsPOJO = new ArrayList<>();
        for (Visit visit : visits) {
                           if(pet_id.equals(visit.getPet().getPet_id())){
                    visitsPOJO.add(new VisitPOJO(
                            visit.getVisit_id(),
                            visit.getCreated_at(),
                            visit.getType(),
                            visit.getDescription(),
                            visit.getPet(),
                            visit.getVet()));
                }
        }
        return visitsPOJO;
    }

    public VisitPOJO createVisit(String visit_id, String created_at,String type,String description,String pet_id,String vet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        Optional<Visit> visit = visitRepository.save(new Visit(visit_id,created_at,type,description), pet_id,vet_id);

        entityManager.close();
        entityManagerFactory.close();

        VisitPOJO visitPOJO = null;
        if (visit.isPresent()) {
            visitPOJO = new VisitPOJO(
                    visit.get().getVisit_id(),
                    visit.get().getCreated_at(),
                    visit.get().getType(),
                    visit.get().getDescription(),
                    visit.get().getPet(),
                    visit.get().getVet());
        }
        return visitPOJO;
    }
/*
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
*/
}
