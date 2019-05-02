package tests.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.Persons;
import tests.domain.PersonsDetails;
import tests.dto.PersonsDetailsDto;
import tests.dto.PersonsDto;
import tests.services.PersonsService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Service
@Path("/api")
public class PersonsRest {
    @Autowired
    private PersonsService personsService;

    @Path("/getAllPersons")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public List<Persons> getAllPersons(String name){
        List<Persons> result = personsService.getAllPersons();
        for(Persons p : result){
            System.out.println(p.getName());
        }
        return result;
    }

    @Path("/getPersonsById")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Persons getUserById(Long id){
        return personsService.getUserByid(id);
    }

    @POST
    @Path("/setPerson")
    @Produces("application/json")
    @Consumes("application/json")
    public void setPerson(PersonsDto personsDto) {
        Persons per = new Persons();
        per.setName(personsDto.getName());
        List<PersonsDetails> details = new ArrayList<>();
        for (PersonsDetailsDto detail : personsDto.getPersonsDetailsDtos()) {
            PersonsDetails perD = new PersonsDetails();
            perD.setAddress(detail.getAddress());
            details.add(perD);
            per.setPersonsDetailsList(details);
        }
        personsService.save(per);
    }
}
