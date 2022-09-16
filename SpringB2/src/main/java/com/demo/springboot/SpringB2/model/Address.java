package com.demo.springboot.SpringB2.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addId;
    @Column(name = "street1")
    private String street1;

    @Column(name="street2")
    private String street2;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="pin_code")
    private Long pinCode;

    @ManyToOne(cascade=CascadeType.ALL)
    private Employee employee;

    public Address() {
    }

    public Address(String street1, String street2, String city, String country, Long pinCode) {

        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.country = country;
        this.pinCode = pinCode;

    }

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(addId, address.addId) &&
                Objects.equals(street1, address.street1) &&
                Objects.equals(street2, address.street2) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country) &&
                Objects.equals(pinCode, address.pinCode) &&
                Objects.equals(employee, address.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addId, street1, street2, city, country, pinCode, employee);
    }
}
