package es.logixs.web.dto;

import es.logixs.web.domain.CounterOffer;

import java.util.UUID;

public class CounterOfferDTO {
    private UUID objectId;
    private String name;
    private String vom;
    private double originalPrice;
    private double counterOfferPrice;
    private double quantity;

    public CounterOfferDTO() {

    }

    public CounterOfferDTO(
            UUID objectId,
            String name,
            String vom,
            double originalPrice,
            double counterOfferPrice,
            double quantity
    ) {
        this.objectId = objectId;
        this.name = name;
        this.vom = vom;
        this.originalPrice = originalPrice;
        this.counterOfferPrice = counterOfferPrice;
        this.quantity = quantity;
    }

    public CounterOfferDTO(CounterOffer counterOffer) {
        this.objectId = counterOffer.getObjectId();
        this.name = counterOffer.getName();
        this.vom = counterOffer.getVom();
        this.originalPrice = counterOffer.getOriginalPrice();
        this.counterOfferPrice = counterOffer.getCounterOfferPrice();
        this.quantity = counterOffer.getQuantity();
    }

    public UUID getObjectId() {
        return objectId;
    }

    public void setObjectId(UUID objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVom() {
        return vom;
    }

    public void setVom(String vom) {
        this.vom = vom;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getCounterOfferPrice() {
        return counterOfferPrice;
    }

    public void setCounterOfferPrice(double counterOfferPrice) {
        this.counterOfferPrice = counterOfferPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public CounterOffer createCounterOffer() {
        return new CounterOffer(
                this.getObjectId(),
                this.getName(),
                this.getVom(),
                this.getOriginalPrice(),
                this.getCounterOfferPrice(),
                this.getQuantity()
        );
    }
}
