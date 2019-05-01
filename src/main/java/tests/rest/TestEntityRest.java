package tests.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.TestEntity;
import tests.services.TestEntityService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Service
@Path("/api")
public class TestEntityRest {
    @Autowired
    private TestEntityService testEntityService;

    @Path("/getName")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public TestEntity getName(String name){
        return testEntityService.getData(name);
    }
}
