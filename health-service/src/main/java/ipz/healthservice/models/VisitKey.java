package ipz.healthservice.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VisitKey implements Serializable {
    @Column(name = "patient_id")
    Long patientId;

    @Column(name = "doctor_id")
    Long doctorId;

    public VisitKey() {
    }

    public VisitKey(Long patientId, Long doctorId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitKey)) return false;
        VisitKey visitKey = (VisitKey) o;
        return Objects.equals(getPatientId(), visitKey.getPatientId()) && Objects.equals(getDoctorId(), visitKey.getDoctorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientId(), getDoctorId());
    }
}
