package tests.domain;

import javax.persistence.*;

@Entity
@Table(name = "persons_roles")
public class PersonsRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_role_id")
    private Long personRoleId;

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
}
