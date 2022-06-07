package ipz.healthservice.models;

import ipz.healthservice.services.BranchService;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    String lastName;
    String oktaUID;

    @ManyToOne
    Branch branch;

    @ManyToOne
    Office office;

    public Doctor() {
    }

    public Doctor(String name, String lastName, String oktaUID, Branch branch, Office office) {
        this.name = name;
        this.lastName = lastName;
        this.oktaUID = oktaUID;
        this.branch = branch;
        this.office = office;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
