package br.com.creative.devlet.model;

import br.com.creative.devlet.enums.EnumState;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;


public class PersonModel {
    private Long id;
    @NotBlank(message = "Name can't be empty")
    @Size(min = 2, max = 50, message = "Name must be within 2 and 8 characters ")
    private String name;
    @NotBlank(message = "Phone can't be empty ")
    @Pattern(regexp = "^[(]\\d{2}[)]\\d{4,5}[-]\\d{4}$", message = "Phone must match the mask: (11)01111-1111")
    private String phone;
    @NotBlank(message = "ZipCod can't be empty")
    @Pattern(regexp = "^\\d{5}\\-\\d{3}$",message = "Zipcode must match the mask: 11.111-111")
    private String zipCode;
    @NotBlank(message = "Street can't be empty")
    @Size(min = 5, max = 150, message = "Street must be within 5 and 150 characters")
    private String street;
    @NotNull(message = "Number can't be empty")
    @Positive(message = "Number must be positive")
    private Integer number;
    @NotBlank(message = "Neighborhood can't be empty")
    @Size(min = 5, max = 80, message = "Neighborhood must be within 5 and 80 characters")
    private String neighborhood;
    @NotBlank(message = "City can't be empty")
    @Size(min = 2, max = 100, message = "City must be within 2 and 100 characters")
    private String city;
    @NotNull(message = "State can't be empty")
    @Enumerated(value = EnumType.STRING)
    private EnumState state;
    @NotBlank(message = "Country can't be empty")
    private String country;
    @NotBlank(message = "Cnpj can't be empty")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}&",message = "Cpf must match the mask: 111.111.111-11")
    private String cpf;
    @NotNull(message = "User_id can't be empty")
    private Long user_id;
    @NotNull(message = "Enterprise_id can't be empty")
    private Long enterprise_id;

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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(Long enterprise_id) {
        this.enterprise_id = enterprise_id;
    }
}
