package es.logixs.web.dto;

import es.logixs.web.domain.User;

import java.util.Date;

public class UserDTO {

    private String objectId;
    private String name;
    private String lastName;
    private String email;
    private String state;
    private String avatar;
    private String password;
    private String prevPasswords;
    private String companyId;
    private String invitedBy;
    private String role;
    private Double limitAmount;
    private String address;
    private String phone;
    private String city;
    private String zipCode;
    private String countryIso;
    private Date createdAt;
    private Date updatedAt;

    public UserDTO() {
    }

    public UserDTO(
            String objectId,
            String name,
            String lastName,
            String email,
            String state,
            String avatar,
            String password,
            String prevPasswords, // Should to be Array<String>
            String companyId,
            String invitedBy,
            String role,
            Double limitAmount,
            String address,
            String phone,
            String city,
            String zipCode,
            String countryIso,
            Date createdAt,
            Date updatedAt
    ) {
        this.objectId = objectId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.state = state;
        this.avatar = avatar;
        this.password = password;
        this.prevPasswords = prevPasswords;
        this.companyId = companyId;
        this.invitedBy = invitedBy;
        this.role = role;
        this.limitAmount = limitAmount;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
        this.countryIso = countryIso;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserDTO(User user) {
        this.objectId = user.getObjectId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.state = user.getState();
        this.avatar = user.getAvatar();
        this.password = user.getPassword();
        this.prevPasswords = user.getPrevPasswords();
        this.companyId = user.getCompanyId();
        this.invitedBy = user.getInvitedBy();
        this.role = user.getRole();
        this.limitAmount = user.getLimitAmount();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.city = user.getCity();
        this.zipCode = user.getZipCode();
        this.countryIso = user.getCountryIso();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrevPasswords() {
        return prevPasswords;
    }

    public void setPrevPasswords(String prevPasswords) {
        this.prevPasswords = prevPasswords;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User crearUsuario() {
        return new User(
                this.getObjectId(),
                this.getName(),
                this.getLastName(),
                this.getEmail(),
                this.getState(),
                this.getAvatar(),
                this.getPassword(),
                this.getPrevPasswords(),
                this.getCompanyId(),
                this.getInvitedBy(),
                this.getRole(),
                this.getLimitAmount(),
                this.getAddress(),
                this.getPhone(),
                this.getCity(),
                this.getZipCode(),
                this.getCountryIso(),
                this.getCreatedAt(),
                this.getUpdatedAt()
        );
    }
}
