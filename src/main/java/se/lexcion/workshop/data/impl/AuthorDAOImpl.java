package se.lexcion.workshop.data.impl;

import org.springframework.stereotype.Repository;
import se.lexcion.workshop.data.dao.AuthorDAO;
import se.lexcion.workshop.entity.Author;
import se.lexcion.workshop.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Author> findById(int id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("Select au from Author au").getResultList();
    }

    @Override
    @Transactional
    public Author creat(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    @Transactional
    public Author update(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<Author> optionalAuthor = findById(id);
        if (optionalAuthor.isPresent()) entityManager.remove(optionalAuthor.get());

    }
}
