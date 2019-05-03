package tests.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonsRolesDto implements Serializable {
    private Long personRoleId;

    private String roleName;

    public Long getPersonRoleId() {
        return personRoleId;
    }

    public void setPersonRoleId(Long personRoleId) {
        this.personRoleId = personRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
