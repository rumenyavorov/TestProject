package tests.services;

import tests.domain.Persons;
import tests.domain.PersonsDetails;

import java.util.List;

public interface PersonsService {
    List<Persons> getAllPersons();
    Persons getUserByid(Long id);

    void save(Persons person);
    void delete(Persons person);
    void merge(Persons person);

    List<PersonsDetails> getAllDetailsByPerson(Long id);
}
