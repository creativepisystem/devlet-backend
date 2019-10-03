package br.com.creative.devlet.model;

import br.com.creative.devlet.enums.EnumEnterpriseType;
import br.com.creative.devlet.enums.EnumState;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$",message = "CNPJ must match the mask: 11.111.111/1111-11")
    private String cnpj;
    @NotNull(message = "Type can't be empty")
    @Enumerated(value = EnumType.STRING)
    private EnumEnterpriseType type;
    @NotNull(message = "Enable must be true or false")
    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return this.street;
    }

    public Integer getNumber() {
        return this.number;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public String getCity() {
        return this.city;
    }

    public EnumState getState() {
        return this.state;
    }

    public void setState(EnumState state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public EnumEnterpriseType getType() {
        return this.type;
    }

    public Boolean getEnabled() {
        return this.enabled;
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

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setType(EnumEnterpriseType type) {
        this.type = type;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
