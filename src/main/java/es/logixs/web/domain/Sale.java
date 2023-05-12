package es.logixs.web.domain;

import java.util.Objects;

public class Sale {

    private String objectId;
    private String ownerId;
    private String clientId;
    private String code;
    private String offerId;
    private String counterOfferId;
    private boolean isCounterOffer;


    public Sale() {
    }

    public Sale(String objectId) {
        this.objectId = objectId;
    }

    public Sale(String objectId, String ownerId, String clientId, String code, String offerId, String counterOfferId,
                boolean isCounterOffer) {
        this.objectId = objectId;
        this.ownerId = ownerId;
        this.clientId = clientId;
        this.code = code;
        this.offerId = offerId;
        this.counterOfferId = counterOfferId;
        this.isCounterOffer = isCounterOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(objectId, sale.objectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId);
    }

    public String getObjectId() {
        return objectId;
    }
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
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
    public String getCounterOfferId() {
        return counterOfferId;
    }
    public void setCounterOfferId(String counterOfferId) {
        this.counterOfferId = counterOfferId;
    }
    public boolean isCounterOffer() {
        return isCounterOffer;
    }
    public void setCounterOffer(boolean isCounterOffer) {
        this.isCounterOffer = isCounterOffer;
    }

}
