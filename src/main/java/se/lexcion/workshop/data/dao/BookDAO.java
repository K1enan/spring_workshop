package se.lexcion.workshop.data.dao;

import se.lexcion.workshop.entity.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookDAO {

    Optional<Book> findById(int book);

    Collection<Book> findAll();

    Book creat(Book book);

    Book update(Book book);

    void delete(int book);

}
