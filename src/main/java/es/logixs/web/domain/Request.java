package es.logixs.web.domain;

import java.util.Objects;

public class Request {
    private String objectId;
    private String code;
    private String offerId;
    private String ownerId;
    private String companyId;

    public Request(String objectId, String code, String offerId, String ownerId, String companyId) {
        this.objectId = objectId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(objectId, request.objectId) && Objects.equals(code, request.code) && Objects.equals(offerId, request.offerId) && Objects.equals(ownerId, request.ownerId) && Objects.equals(companyId, request.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, code, offerId, ownerId, companyId);
    }

    public Request(String objectId) {
        this.objectId = objectId;
    }

    public Request() {
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

    public void setCompanyId(String companyID) {
        this.companyId = companyID;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "objectId='" + objectId + '\'' +
                ", code='" + code + '\'' +
                ", offerId='" + offerId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
