package se.lexcion.workshop.data.impl;

import org.springframework.stereotype.Repository;
import se.lexcion.workshop.data.dao.BookDAO;
import se.lexcion.workshop.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Book> findById(int id) {

        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    public List findAll() {
        return entityManager.createQuery("Select a from Book a").getResultList();
    }

    @Override
    @Transactional
    public Book creat(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    @Transactional
    public void delete(int book) {
        Optional<Book> optionalBook = findById(book);
        if (optionalBook.isPresent()) entityManager.remove(optionalBook.get());
    }

}

