package se.lexcion.workshop.data.dao;

import se.lexcion.workshop.entity.Details;

import java.util.List;
import java.util.Optional;

public interface DetailsDAO {

    Optional<Details> findById(int id);

    List findAll();

    Details create(Details details);

    Details update(Details details);

    void delete(int details);


}
