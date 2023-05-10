package es.logixs.web.domain;

public class Request {
    private String id;
    private String code;
    private String offerId;
    private String ownerId;
    private String companyId;

    public Request(String id, String code, String offerId, String ownerId, String companyId) {
        this.id = id;
        this.code = code;
        this.offerId = offerId;
        this.ownerId = ownerId;
        this.companyId = companyId;
    }

    public Request(String code, String offerId, String ownerId, String companyId) {
        this.code = code;
        this.offerId = offerId;
        this.ownerId = ownerId;
        this.companyId = companyId;
    }


    public Request(String id) {
        this.id = id;
    }

    public Request() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyID) {
        this.companyId = companyID;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", offerId='" + offerId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
