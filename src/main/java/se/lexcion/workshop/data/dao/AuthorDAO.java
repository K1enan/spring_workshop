package se.lexcion.workshop.data.dao;

import se.lexcion.workshop.entity.Author;

import java.util.Collection;
import java.util.Optional;

public interface AuthorDAO {

    Optional<Author> findById(int id);

    Collection<Author> findAll();

    Author creat(Author author);

    Author update(Author author);

    void delete(int id);


}
