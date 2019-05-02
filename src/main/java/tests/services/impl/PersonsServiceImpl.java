package tests.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.Persons;
import tests.services.PersonsService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
}
