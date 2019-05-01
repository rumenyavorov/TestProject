package tests.services;

import tests.domain.Persons;

import java.util.List;

public interface PersonsService {
    List<Persons> getAllPersons();
    Persons getUserByid(Long id);

    void save(Persons person);
    void delete(Persons person);
}
