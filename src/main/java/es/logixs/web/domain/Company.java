package es.logixs.web.domain;

import java.util.Date;

public class Company {
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

    public Company(String objectId, String code, String state, String licenseId, int limitUsers, String name, String address, String phone, String countryIso, String taxId, String url, Date createAt, Date updateAt) {
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

    public Company(String objectId, String code, String licenseId, String name, String taxId) {
        this.objectId = objectId;
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
    }

    public Company(String objectId) {
        this.objectId = objectId;
    }

    public Company() {
    }

    public Company(String code, String licenseId, String name, String taxId) {
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((objectId == null) ? 0 : objectId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Company other = (Company) obj;
        if (objectId == null) {
            if (other.objectId != null)
                return false;
        } else if (!objectId.equals(other.objectId))
            return false;
        return true;
    }

    
}
