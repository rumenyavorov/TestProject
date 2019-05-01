package tests.services;

import tests.domain.Persons;
import tests.domain.PersonsDetails;
import tests.dto.PersonsDto;

import java.util.List;

public interface PersonsDetailsService {
    void save(PersonsDetails personsDetails);
    void delete(PersonsDetails personsDetails);
}
