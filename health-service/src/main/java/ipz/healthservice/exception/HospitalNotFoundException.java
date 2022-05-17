package ipz.healthservice.exception;

public class HospitalNotFoundException extends RuntimeException {
    public HospitalNotFoundException(Long id) {
        super("Could not find hospital with id: " + id);
    }
    public HospitalNotFoundException(String name) {
        super("Could not find hospital with name: " + name);
    }
}
