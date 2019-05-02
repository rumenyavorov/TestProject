package tests.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.Persons;
import tests.domain.PersonsDetails;
import tests.services.PersonsService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {
    @Autowired
    EntityManager em;
    @Override
    public List<Persons> getAllPersons() {
        Query q = em.createQuery("select p from Persons p");
        List<Persons> persons = q.getResultList();
        if(null == persons){
            persons = new ArrayList<Persons>();
        }
        return persons;
//        return em.createQuery("select p from Persons p").getResultList();
    }

    @Override
    public Persons getUserByid(Long id) {
        Query q = em.createQuery("select p from Persons p where p.id = :id");
        q.setParameter("id", id);
        Persons person = (Persons) q.getSingleResult();
        if(null == person){
            person = new Persons();
        }
        return person;
    }

    @Override
    @Transactional
    public void save(Persons person) {
        em.persist(person);
        em.flush();
    }

    @Override
    @Transactional
    public void delete(Persons person) {
        em.remove(person);
    }

    @Override
    @Transactional
    public void merge(Persons person){
        em.merge(person);
    }

    @Override
    public List<PersonsDetails> getAllDetailsByPerson(Long id) {
        Query q = em.createNativeQuery("select pd.* from person_details as pd " +
                " inner join persons as p on p.persons_id = pd.persons_id " +
                " where p.persons_id = :id");
        q.setParameter("id", id);

        List<Object[]> result = q.getResultList();
        List<PersonsDetails> personsDetails = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            PersonsDetails details = new PersonsDetails();
            details.setPersonDetailsId(((BigInteger)result.get(i)[0]).longValue());
            details.setAddress((String) result.get(i)[1]);
            personsDetails.add(details);
        }

        return personsDetails;
    }
}
