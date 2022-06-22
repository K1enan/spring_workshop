package se.lexcion.workshop.data.impl;

import org.springframework.stereotype.Repository;
import se.lexcion.workshop.data.dao.BookLoanDAO;
import se.lexcion.workshop.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class BookLoanDAOImpl implements BookLoanDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<BookLoan> findById(int id) {
        return Optional.ofNullable(entityManager.find(BookLoan.class, id));
    }

    @Override
    public List findAll() {
        return entityManager.createQuery("Select a from BookLoan a").getResultList();
    }

    @Override
    @Transactional
    public BookLoan creat(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    @Transactional
    public void delete(int bookLoan) {
        Optional<BookLoan> optionalBookLoan = findById(bookLoan);
        if (optionalBookLoan.isPresent()) entityManager.remove(optionalBookLoan.get());
    }
}
