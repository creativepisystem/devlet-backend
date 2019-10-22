package br.com.creative.devlet.entity;

import br.com.creative.devlet.enums.EnumState;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    private Long id;


    @OneToOne
    @JoinColumn(name = "id")
    @MapsId(value = "id")
    private User user;

    @Column
    private String name;

    @Column
    private String phone;

    @Column(name = "zipcode")
    private String zipCode;

    @Column
    private String street;

    @Column
    private Integer number;

    @Column
    private String neighborhood;

    @Column
    private String city;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumState state;

    @Column
    private String country;

    @Column(unique = true)
    private String cpf;


    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public EnumState getState() {
        return state;
    }

    public void setState(EnumState state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
