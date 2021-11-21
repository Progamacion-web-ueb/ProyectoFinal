package co.edu.unbosque.proyectofinalbackend.jpa.repositories;

import co.edu.unbosque.proyectofinalbackend.jpa.entities.Official;
import javax.persistence.EntityManager;
import java.util.Optional;

public class OfficialRepositoryImpl implements  OfficialRepository{

    private EntityManager entityManager;

    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Official> save(Official official) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(official);
            entityManager.getTransaction().commit();
            return Optional.of(official);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Official Update(String username,String name) {
        Official official = entityManager.createNamedQuery("Official.update",Official.class)
                //.setParameter("username", username)
                .setParameter("name", name)
                .getSingleResult();
        return official ;
    }
}
