package es.logixs.web.dto;

import es.logixs.web.domain.Sale;

public class SaleDTO {
    private String objectId;
    private String ownerId;
    private String clientId;
    private String code;
    private String offerId;
    private String counterOfferId;
    private boolean isCounterOffer;

    public SaleDTO() {
    }

    public SaleDTO(
            String objectId,
            String ownerId,
            String clientId,
            String code,
            String offerId,
            String counterOfferId,
            boolean isCounterOffer
    ) {
        this.objectId = objectId;
        this.ownerId = ownerId;
        this.clientId = clientId;
        this.code = code;
        this.offerId = offerId;
        this.counterOfferId = counterOfferId;
        this.isCounterOffer = isCounterOffer;
    }

    public SaleDTO(Sale sale) {
        this.objectId = sale.getObjectId();
        this.ownerId = sale.getOwnerId();
        this.clientId = sale.getClientId();
        this.code = sale.getCode();
        this.offerId = sale.getOfferId();
        this.counterOfferId = sale.getCounterOfferId();
        this.isCounterOffer = sale.isCounterOffer();
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

    public void setCounterOffer(boolean CounterOffer) {
        isCounterOffer = CounterOffer;
    }

    public Sale createSale() {
        return new Sale(
                getObjectId(),
                getOwnerId(),
                getClientId(),
                getCode(),
                getOfferId(),
                getCounterOfferId(),
                isCounterOffer()
        );
    }
}
