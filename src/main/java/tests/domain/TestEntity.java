package tests.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bytes")
    private byte byt;

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

    public byte getByt() {
        return byt;
    }

    public void setByt(byte byt) {
        this.byt = byt;
    }
}
