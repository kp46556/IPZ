package ipz.healthservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Visit {
    @EmbeddedId
    private VisitKey visitKey;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    @ManyToOne
    @MapsId("patientId")
    @JoinColumn(name = "patient_id")
    Patient patient;

    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    public Visit() {
    }

    public Visit(Patient patient, Doctor doctor, Date date) {
        this.visitKey = new VisitKey(patient.getId(), doctor.getId());
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public VisitKey getId() {
        return visitKey;
    }

    public void setId(VisitKey id) {
        this.visitKey = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
