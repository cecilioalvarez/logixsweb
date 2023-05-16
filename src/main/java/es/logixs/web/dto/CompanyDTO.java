package es.logixs.web.dto;
import es.logixs.web.domain.Company;

import java.util.Date;

public class CompanyDTO {

    private String objectId;
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
    private Date createAt;
    private Date updateAt;

    public CompanyDTO(){

    }

    public CompanyDTO(String objectId, String code, String licenseId, String name, String taxId) {
        this.objectId = objectId;
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
    }


    public CompanyDTO(String objectId, String code, String state, String licenseId, int limitUsers, String name, String address, String phone, String countryIso, String taxId, String url, Date createAt, Date updateAt) {
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
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public CompanyDTO (Company company) {
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
        this.createAt = company.getCreateAt();
        this.updateAt = company.getUpdateAt();
    }

    public Company createCompany(){
        return new Company(this.getObjectId(),this.getCode(),this.getLicenseId(),this.getName(),this.getTaxId());
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
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
