package br.com.creative.devlet.model;

import br.com.creative.devlet.validations.Cnpj;
import br.com.creative.devlet.validations.Empty;

import javax.validation.constraints.*;

public class EnterpriseCreateUpdateModel {

    private Long id;
    @NotBlank(message = "Name can't be empty")
    @Size(min = 2, max = 100, message = "Name must be within 2 and 8 characters ")
    private String name;
    @NotBlank(message = "Phone can't be empty ")
    @Pattern(regexp = "^[(]\\d{2}[)]\\d{4,5}[-]\\d{4}$", message = "Phone must match the mask: (11)01111-1111")
    private String phone;
    @NotBlank(message = "Email can't be empty")
    @Email(message = "Email must be a valid email")
    private String email;
    @NotBlank(message = "ZipCod can't be empty")
    @Size(min = 8, max = 8, message = "Zipcode must have 8 numbers")
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
    @NotBlank(message = "State can't be empty")
    private String state;
    @NotBlank(message = "Country can't be empty")
    private String country;
    @NotBlank(message = "Cnpj can't be empty")
    @Cnpj(message = "Cnpj must be a valid Cnpj")
    private String cnpj;
    @NotBlank(message = "Type can't be empty")
    private String type;
    @Empty(message = "Enable must be true or false")
    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone.replaceAll("[\\W]", "");
    }

    public String getEmail() {
        return email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getCnpj() {
        return cnpj.replaceAll("[\\W]", "");
    }

    public String getType() {
        return type;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
