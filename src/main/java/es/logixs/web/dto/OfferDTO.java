package es.logixs.web.dto;

import es.logixs.web.domain.Offer;

public class OfferDTO {

    private String objectId;
    private String code;
    private String name;
    private String description;
    private String category;


    public OfferDTO() {
    }

    public OfferDTO(String objectId, String code, String name, String description, String category) {
        this.objectId = objectId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public OfferDTO(Offer offer) {
        this.objectId = offer.getObjectId();
        this.code = offer.getCode();
        this.name = offer.getName();
        this.description = offer.getDescription();
        this.category = offer.getCategory();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Offer createOffer() {
        Offer offer = new Offer();
        offer.setObjectId(this.getObjectId());
        offer.setCode(this.getCode());
        offer.setName(this.getName());
        offer.setDescription(this.getDescription());
        offer.setCategory(this.getCategory());
        return offer;
    }
}
