package es.logixs.web.dto;

import es.logixs.web.domain.Request;

public class RequestDTO {
    private String objectId;
    private String code;
    private String offerId;
    private String ownerId;
    private String companyId;

    public RequestDTO() {
    }

    public RequestDTO(String objectId, String code, String offerId, String ownerId, String companyId) {
        this.objectId = objectId;
        this.code = code;
        this.offerId = offerId;
        this.ownerId = ownerId;
        this.companyId = companyId;
    }

    public RequestDTO(Request request) {
        this.objectId = request.getObjectId();
        this.code = request.getCode();
        this.offerId = request.getOfferId();
        this.ownerId = request.getOwnerId();
        this.companyId = request.getCompanyId();
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

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Request createRequest() {
        return new Request(this.objectId, this.code, this.offerId,this.ownerId ,this.companyId);
    }
}
