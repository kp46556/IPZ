package ipz.healthservice.models;

import javax.persistence.*;

@Entity
public class DoctorsOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Integer officeNumber;

    @ManyToOne
    Branch branch;

    public DoctorsOffice() {
    }

    public Integer getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(Integer officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
