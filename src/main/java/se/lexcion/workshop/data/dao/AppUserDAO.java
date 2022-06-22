package se.lexcion.workshop.data.dao;

import se.lexcion.workshop.entity.AppUser;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDAO {

    Optional<AppUser> findById(int id);

    Collection<AppUser> findAll();

    AppUser creat(AppUser appUser);

    AppUser update(AppUser appUser);

    void delete(int appUser);


}
