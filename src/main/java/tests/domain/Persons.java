package tests.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Persons {

    @Id
    @Column(name = "persons_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long personsId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "persons_id")
    private List<PersonsDetails> personsDetailsList;

    public Long getPersonsId() {
        return personsId;
    }

    public void setPersonsId(Long personsId) {
        this.personsId = personsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonsDetails> getPersonsDetailsList() {
        return personsDetailsList;
    }

    public void setPersonsDetailsList(List<PersonsDetails> personsDetailsList) {
        this.personsDetailsList = personsDetailsList;
    }
}
