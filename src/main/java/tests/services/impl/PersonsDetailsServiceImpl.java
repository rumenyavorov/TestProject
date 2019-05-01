package tests.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.PersonsDetails;
import tests.services.PersonsDetailsService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class PersonsDetailsServiceImpl implements PersonsDetailsService {
    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public void save(PersonsDetails personsDetails) {
        em.persist(personsDetails);
    }

    @Override
    @Transactional
    public void delete(PersonsDetails personsDetails) {
        em.remove(personsDetails);
    }
}
