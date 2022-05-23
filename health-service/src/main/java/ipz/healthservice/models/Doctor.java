package ipz.healthservice.models;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;
    String lastName;
    String spec;
    @ManyToOne
    DoctorsOffice doctorsOffice;

    public Doctor() {
    }

    public Doctor(String name, String lastName, String spec, DoctorsOffice doctorsOffice) {
        this.name = name;
        this.lastName = lastName;
        this.spec=spec;
        this.doctorsOffice = doctorsOffice;
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

    public String getSpec() { return spec; }

    public void setSpec(String spec) { this.spec = spec; }
    public DoctorsOffice getDoctorsOffice() {
        return doctorsOffice;
    }

    public void setDoctorsOffice(DoctorsOffice doctorsOffice) {
        this.doctorsOffice = doctorsOffice;
    }
}
