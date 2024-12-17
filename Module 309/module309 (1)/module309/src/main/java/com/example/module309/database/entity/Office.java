package com.example.module309.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "territory")
    private String territory;

    public Office() {

    }

    public Office(int id, String city, String phone, String address_line1, String address_line2, String state, String country, String postal_code, String territory) {
        this.id = id;
        this.city = city;
        this.phone = phone;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.state = state;
        this.country = country;
        this.postal_code = postal_code;
        this.territory = territory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", address_line1='" + address_line1 + '\'' +
                ", address_line2='" + address_line2 + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", territory='" + territory + '\'' +
                '}';
    }
}
