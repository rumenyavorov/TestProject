package tests.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.domain.Persons;
import tests.domain.PersonsDetails;
import tests.dto.PersonsDetailsDto;
import tests.services.PersonsDetailsService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Service
@Path("/test")
public class PersonsDetailsRest {
    @Autowired
    private PersonsDetailsService personsDetailsService;

//    @Path("/apit")
//    @POST
//    @Produces("application/json")
//    @Consumes("application/json")
//    public List<Persons> getAllInfo(Long id){
//        return personsDetailsService.getAllInfo(id);
//    }

    @Path("/setName")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public void setName(PersonsDetailsDto personsDetailsDto){
        PersonsDetails perso = new PersonsDetails();
        perso.setCity(personsDetailsDto.getCity());
        perso.setEmail(personsDetailsDto.getEmail());
        perso.setFirstName(personsDetailsDto.getFirstName());
        perso.setLastName(personsDetailsDto.getLastName());
        perso.setPhoneNumber(personsDetailsDto.getPhoneNumber());
        //perso.setAddress(personsDetailsDto.getAddress());
        personsDetailsService.save(perso);
    }
}
