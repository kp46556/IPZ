package ipz.healthservice.models;

import javax.persistence.*;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String name;
    String street;
    String number;
    String city;
    String postCode;
    String type;
    Double lng;
    Double lat;

    public Hospital() {
    }

    public Hospital(String name, String street, String number, String city, String postCode, String type, Double lng, Double lat) {
        this.name = name;
        this.street = street;
        this.number=number;
        this.city=city;
        this.postCode=postCode;
        this.type = type;
        this.lng = lng;
        this.lat = lat;
    }

    public Hospital(Long id, String name, String street, String number, String city, String postCode, String type, Double lng, Double lat) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.number=number;
        this.city=city;
        this.postCode=postCode;
        this.type = type;
        this.lng = lng;
        this.lat = lat;
    }

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getPostCode() { return postCode; }

    public void setPostCode(String postCode) { this.postCode = postCode; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
