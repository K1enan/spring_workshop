package se.lexcion.workshop.data.dao;

import se.lexcion.workshop.entity.BookLoan;

import java.util.Collection;
import java.util.Optional;

public interface BookLoanDAO {

    Optional<BookLoan> findById(int id);

    Collection<BookLoan> findAll();

    BookLoan creat(BookLoan bookLoan);

    BookLoan update(BookLoan bookLoan);

    void delete(int bookLoan);

}
