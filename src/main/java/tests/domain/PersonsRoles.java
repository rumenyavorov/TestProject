package tests.domain;

import javax.persistence.*;

@Entity
@Table(name = "persons_roles")
public class PersonsRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_role_id")
    private Long personRoleId;

    @Column(name = "person_role")
    private Long personRole;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "persons_id")
    private Persons persons;

    public Long getPersonRoleId() {
        return personRoleId;
    }

    public void setPersonRoleId(Long personRoleId) {
        this.personRoleId = personRoleId;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    public Long getPersonRole() {
        return personRole;
    }

    public void setPersonRole(Long personRole) {
        this.personRole = personRole;
    }
}
