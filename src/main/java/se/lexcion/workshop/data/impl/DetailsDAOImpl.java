package se.lexcion.workshop.data.impl;

import org.springframework.stereotype.Repository;
import se.lexcion.workshop.data.dao.DetailsDAO;
import se.lexcion.workshop.entity.Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class DetailsDAOImpl implements DetailsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Details> findById(int id) {
        Details details = entityManager.find(Details.class, id);
        return Optional.ofNullable(details);
    }

    @Override
    public List findAll() {
        return entityManager.createQuery("select d from Details d").getResultList();
    }

    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    public void delete(int details) {
        Optional<Details> optionalDetails = findById(details);
        if (optionalDetails.isPresent()) entityManager.remove(optionalDetails.get());

    }

}
