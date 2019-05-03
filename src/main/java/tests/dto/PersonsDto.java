package tests.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonsDto implements Serializable {

    private Long id;
    private String name;
    private List<PersonsDetailsDto> personsDetailsDtos;
    private List<PersonsRolesDto> personsRolesDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonsDetailsDto> getPersonsDetailsDtos() {
        return personsDetailsDtos;
    }

    public void setPersonsDetailsDtos(List<PersonsDetailsDto> personsDetailsDtos) {
        this.personsDetailsDtos = personsDetailsDtos;
    }

    public List<PersonsRolesDto> getPersonsRolesDtos() {
        return personsRolesDtos;
    }

    public void setPersonsRolesDtos(List<PersonsRolesDto> personsRolesDtos) {
        this.personsRolesDtos = personsRolesDtos;
    }
}
