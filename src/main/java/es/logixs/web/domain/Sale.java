package es.logixs.web.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Sale {
    @Id
    @Type(type="uuid-char")
    private UUID objectId;
    private String ownerId;
    private String clientId;
    private String code;
    private String offerId;
    private String counterOfferId;
    private boolean isCounterOffer;


    public Sale() {
    }

    public Sale(UUID objectId) {
        this.objectId = objectId;
    }

    public Sale(UUID objectId, String ownerId, String clientId, String code, String offerId, String counterOfferId,
                boolean isCounterOffer) {
        this.objectId = objectId;
        this.ownerId = ownerId;
        this.clientId = clientId;
        this.code = code;
        this.offerId = offerId;
        this.counterOfferId = counterOfferId;
        this.isCounterOffer = isCounterOffer;
    }

    public UUID getObjectId() {
        return objectId;
    }
    public void setObjectId(UUID objectId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return isCounterOffer == sale.isCounterOffer && Objects.equals(objectId, sale.objectId) && Objects.equals(ownerId, sale.ownerId) && Objects.equals(clientId, sale.clientId) && Objects.equals(code, sale.code) && Objects.equals(offerId, sale.offerId) && Objects.equals(counterOfferId, sale.counterOfferId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, ownerId, clientId, code, offerId, counterOfferId, isCounterOffer);
    }
}
