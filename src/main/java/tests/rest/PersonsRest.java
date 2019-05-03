package tests.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.Persons;
import tests.domain.PersonsDetails;
import tests.domain.PersonsRoles;
import tests.domain.Roles;
import tests.dto.PersonsDetailsDto;
import tests.dto.PersonsDto;
import tests.dto.PersonsRolesDto;
import tests.services.PersonsService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
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

        List<PersonsRoles> roles = new ArrayList<>();
        List<PersonsDetails> details = new ArrayList<>();

        for (PersonsDetailsDto detail : personsDto.getPersonsDetailsDtos()) {
            PersonsDetails perD = new PersonsDetails();
            perD.setAddress(detail.getAddress());
            perD.setCity(detail.getCity());
            perD.setEmail(detail.getEmail());
            perD.setFirstName(detail.getFirstName());
            perD.setLastName(detail.getLastName());
            perD.setPhoneNumber(detail.getPhoneNumber());

            details.add(perD);
            per.setPersonsDetailsList(details);
        }

        for(PersonsRolesDto rolesDto : personsDto.getPersonsRolesDtos()){
            PersonsRoles perR = new PersonsRoles();
            perR.setPersonRoleId(rolesDto.getPersonRoleId());
            roles.add(perR);
            per.setPersonsRolesList(roles);
        }
        personsService.save(per);
    }

    @POST
    @Path("/updatePerson")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updatePerson(PersonsDto personsDto) {
        Persons per = personsService.getUserByid(personsDto.getId());

        List<PersonsDetails> personsDetails = per.getPersonsDetailsList();
//        for(int i = 0;i < personsDto.getPersonsDetailsDtos().size(); i++){
            PersonsDetails personsDetail = personsDetails.get(2);
            personsDetail.setAddress("jfhhdgfdfdgfgddgfdgfdgfdgfd");
            personsDetails.add(personsDetail);
//        }

        per.setPersonsDetailsList(personsDetails);
        personsService.merge(per);

        return Response.ok().entity(personsDto).build();
    }

    @POST
    @Path("/getPersonDetails")
    @Produces("application/json")
    @Consumes("application/json")
    public Response getPersonDetails(Long id) {
        List<PersonsDetails> details = personsService.getAllDetailsByPerson(id);

        return Response.ok().entity(details).build();
    }
}
