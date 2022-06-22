package se.lexcion.workshop.data.impl;

import org.springframework.stereotype.Repository;
import se.lexcion.workshop.data.dao.AppUserDAO;
import se.lexcion.workshop.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class AppUserDAOImpl implements AppUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<AppUser> findById(int id) {
        return Optional.ofNullable(entityManager.find(AppUser.class, id));
    }

    @Override
    public List findAll() {

        return entityManager.createQuery("Select a from AppUser a").getResultList();
    }

    @Override
    @Transactional
    public AppUser creat(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(int appUser) {
        // step1 call find by id method then if it returns a data you can pass it to remove method.
        Optional<AppUser> optionalAppUser = findById(appUser);
        if (optionalAppUser.isPresent()) entityManager.remove(optionalAppUser.get());

    }

}
