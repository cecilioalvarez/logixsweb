package es.logixs.web.dto;

import es.logixs.web.domain.Company;

import java.util.Date;
import java.util.UUID;

public class CompanyDTO {

    private UUID objectId;
    private String code;
    private String state;
    private String licenseId;
    private int limitUsers;
    private String name;
    private String address;
    private String phone;
    private String countryIso;
    private String taxId;
    private String url;
    private Date createdAt;
    private Date updatedAt;

    public CompanyDTO() {

    }

    public CompanyDTO(UUID objectId, String code, String licenseId, String name, String taxId) {
        this.objectId = objectId;
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
    }

    public CompanyDTO(UUID objectId, String code, String state, String licenseId, int limitUsers, String name,
                      String address, String phone, String countryIso, String taxId, String url, Date createdAt, Date updatedAt) {
        this.objectId = objectId;
        this.code = code;
        this.state = state;
        this.licenseId = licenseId;
        this.limitUsers = limitUsers;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.countryIso = countryIso;
        this.taxId = taxId;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CompanyDTO(Company company) {
        this.objectId = company.getObjectId();
        this.code = company.getCode();
        this.state = company.getState();
        this.licenseId = company.getLicenseId();
        this.limitUsers = company.getLimitUsers();
        this.name = company.getName();
        this.address = company.getAddress();
        this.phone = company.getPhone();
        this.countryIso = company.getCountryIso();
        this.taxId = company.getTaxId();
        this.url = company.getUrl();
        this.createdAt = company.getCreatedAt();
        this.updatedAt = company.getUpdatedAt();
    }

    public Company createCompany() {
        return new Company(this.getObjectId(), this.getCode(), this.getState(), this.getLicenseId(),
                this.getLimitUsers(), this.getName(), this.getAddress(), this.getPhone(), this.getCountryIso(),
                this.getTaxId(), this.getUrl(), this.getCreatedAt(), this.getUpdatedAt());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLimitUsers() {
        return limitUsers;
    }

    public void setLimitUsers(int limitUsers) {
        this.limitUsers = limitUsers;
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

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public UUID getObjectId() {
        return objectId;
    }

    public void setObjectId(UUID objectId) {
        this.objectId = objectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
