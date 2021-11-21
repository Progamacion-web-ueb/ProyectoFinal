package co.edu.unbosque.proyectofinalbackend.services;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OfficialRepository;
import co.edu.unbosque.proyectofinalbackend.jpa.repositories.OfficialRepositoryImpl;
import co.edu.unbosque.proyectofinalbackend.resources.pojos.OfficialPOJO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public Optional<OfficialPOJO> createOfficial(OfficialPOJO officialPOJO) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Official  official = new Official(officialPOJO.getUsername(),officialPOJO.getPassword(),officialPOJO.getEmail(),officialPOJO.getName());

        Optional<Official> persistedOfficial = officialRepository.save(official);
        entityManager.close();
        entityManagerFactory.close();

        if (persistedOfficial.isPresent()) {
            return Optional.of(new OfficialPOJO( persistedOfficial.get().getUsername(),
                    persistedOfficial.get().getPassword(),
                    persistedOfficial.get().getEmail(),
                    persistedOfficial.get().getName()));
        }else {
            return Optional.empty();
        }
    }

    public Official update(String username,String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Official official= officialRepository.Update(username,name);

        entityManager.close();
        entityManagerFactory.close();

        return official;

    }

}
