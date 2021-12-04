package co.edu.unbosque.proyectofinalbackend.services;


import co.edu.unbosque.proyectofinalbackend.jpa.entities.Vet;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.VetRepository;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.VetRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class VetService {

    VetRepository vetRepository;

    public List<VetPOJO> listVets() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        List<Vet> vets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VetPOJO> vetsPOJO = new ArrayList<>();
        for (Vet vet : vets){
            vetsPOJO.add(new VetPOJO(
                    vet.getUsername(),
                    vet.getPassword(),
                    vet.getEmail(),
                    vet.getName(),
                    vet.getAddress(),
                    vet.getNeighborhood()));
        }
        return vetsPOJO;
    }

    public Optional<VetPOJO> createVet(VetPOJO vetPOJO) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);

        Vet vet = new Vet( vetPOJO.getUsername(),vetPOJO.getPassword(),vetPOJO.getEmail(),vetPOJO.getName()
                , vetPOJO.getAddress(), vetPOJO.getNeighborhood());
        Optional<Vet> persistedVet = vetRepository.save(vet);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVet.isPresent()) {
            return Optional.of(new VetPOJO(
                    persistedVet.get().getUsername(),
                    persistedVet.get().getPassword(),
                    persistedVet.get().getEmail(),
                    persistedVet.get().getName(),
                    persistedVet.get().getAddress(),
                    persistedVet.get().getNeighborhood()));
        } else {
            return Optional.empty();
        }

    }

}
