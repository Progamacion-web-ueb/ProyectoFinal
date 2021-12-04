package co.edu.unbosque.proyectofinalbackend.services;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import co.edu.unbosque.proyectofinalbackend.jpa.entities.Owner;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OfficialRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OwnerRepository;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.OfficialPOJO;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.OwnerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class OwnerService {

    OwnerRepository ownerRepository;

    public List<OwnerPOJO> listOwners() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        List<Owner> owners = ownerRepository.findAll();
        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPOJO> ownersPOJO = new ArrayList<>();
        for (Owner owner : owners) {
            ownersPOJO.add(new OwnerPOJO(
                    owner.getUsername(),
                    owner.getPassword(),
                    owner.getEmail(),
                    owner.getPersonId(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getNeighborhood()));
        }

        return ownersPOJO;
    }

    public Optional<OwnerPOJO> createOwner(OwnerPOJO ownerPOJO) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Owner owner = new Owner(ownerPOJO.getUsername(), ownerPOJO.getPassword(), ownerPOJO.getEmail(),
                ownerPOJO.getPersonId(), ownerPOJO.getName(), ownerPOJO.getAddress(), ownerPOJO.getNeighborhood());
        Optional<Owner> persistedOwner = ownerRepository.save(owner);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOwner.isPresent()) {
            return Optional.of(new OwnerPOJO(persistedOwner.get().getUsername(),
                    persistedOwner.get().getPassword(),
                    persistedOwner.get().getEmail(),
                    persistedOwner.get().getPersonId(),
                    persistedOwner.get().getName(),
                    persistedOwner.get().getAddress(),
                    persistedOwner.get().getNeighborhood()));
        } else {
            return Optional.empty();
        }

    }

}
