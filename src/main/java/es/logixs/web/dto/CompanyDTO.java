package es.logixs.web.dto;
import es.logixs.web.domain.Company;

public class CompanyDTO {

    private String objectId;
    private String code;
    private String licenseId;
    private String name;
    private String taxId;

    public CompanyDTO(){

    }

    public CompanyDTO(String objectId, String code, String licenseId, String name, String taxId) {
        this.objectId = objectId;
        this.code = code;
        this.licenseId = licenseId;
        this.name = name;
        this.taxId = taxId;
    }

    public CompanyDTO (Company company){
        this.objectId = company.getObjectId();
        this.code = company.getCode();
        this.licenseId = company.getLicenseId();
        this.name = company.getName();
        this.taxId = company.getTaxId();
    }

    public Company createCompany(){
        return new Company(this.getObjectId(),this.getCode(),this.getLicenseId(),this.getName(),this.getTaxId());
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
