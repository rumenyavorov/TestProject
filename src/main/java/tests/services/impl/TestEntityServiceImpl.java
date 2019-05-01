package tests.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.TestEntity;
import tests.services.TestEntityService;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class TestEntityServiceImpl implements TestEntityService {
    @Autowired
    EntityManager em;

    @Override
    public TestEntity getData(String name) {
        Query q = em.createQuery("select t from TestEntity t where t.name = :name");
        q.setParameter("name", name);
        TestEntity testEntity = (TestEntity) q.getSingleResult();
        if(null == testEntity){
            testEntity = new TestEntity();
        }
        return testEntity;
    }
}
