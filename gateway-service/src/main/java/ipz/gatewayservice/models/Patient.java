package ipz.gatewayservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Patient() {
    }

    public Patient(String name, String lastName, String oktaUID) {
        this.name = name;
        this.lastName = lastName;
        this.oktaUID = oktaUID;
    }

    String name;
    String lastName;
    String oktaUID;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOktaUID() {
        return oktaUID;
    }

    public void setOktaUID(String oktaUID) {
        this.oktaUID = oktaUID;
    }

    public Long getId() {
        return id;
    }
}
