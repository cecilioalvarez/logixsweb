package es.logixs.web.domain;

public class Company {
    private String objectId;
    private String code;
    private String licenseId;
    private String name;
    private String taxId;

    public Company(String objectid, String code, String licenseId, String name, String taxId) {
        this.objectId = objectid;
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
    }

    public Company(String objectid) {
        this.objectId = objectid;
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

    public void setObjectId(String objectid) {
        this.objectId = objectid;
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
