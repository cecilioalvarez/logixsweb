package es.logixs.web.dto;

import es.logixs.web.domain.Request;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class RequestDTO {
    private UUID objectId;
    private String code;
    private UUID offerId;
    private UUID ownerId;
    private UUID companyId;
    private boolean isAccepted;
    private UUID[] privateCompanyIds;
    private String category;
    private String scientificName;
    private String name;
    private String originalCountryIso;
    private String description;
    private String productionMethod;
    private int glazing;
    private String currency;
    private Date createdAt;
    private Date updatedAt;

    public RequestDTO(Request request) {
        this.objectId = request.getObjectId();
        this.code = request.getCode();
        this.offerId = request.getOfferId();
        this.ownerId = request.getOwnerId();
        this.companyId = request.getCompanyId();
        this.isAccepted = request.isAccepted();
        this.privateCompanyIds = request.getPrivateCompanyIds();
        this.category = request.getCategory();
        this.scientificName = request.getScientificName();
        this.name = request.getName();
        this.originalCountryIso = request.getOriginalCountryIso();
        this.description = request.getDescription();
        this.productionMethod = request.getProductionMethod();
        this.glazing = request.getGlazing();
        this.currency = request.getCurrency();
        this.createdAt = request.getCreatedAt();
        this.updatedAt = request.getUpdatedAt();
    }

    public RequestDTO(UUID objectId, String code, UUID offerId, UUID ownerId, UUID companyId, boolean isAccepted, UUID[] privateCompanyIds, String category, String scientificName, String name, String originalCountryIso, String description, String productionMethod, int glazing, String currency, Date createdAt, Date updatedAt) {
        this.objectId = objectId;
        this.code = code;
        this.offerId = offerId;
        this.ownerId = ownerId;
        this.companyId = companyId;
        this.isAccepted = isAccepted;
        this.privateCompanyIds = privateCompanyIds;
        this.category = category;
        this.scientificName = scientificName;
        this.name = name;
        this.originalCountryIso = originalCountryIso;
        this.description = description;
        this.productionMethod = productionMethod;
        this.glazing = glazing;
        this.currency = currency;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public RequestDTO(UUID objectId) {
        this.objectId = objectId;
    }

    public RequestDTO() {
    }



    public UUID getObjectId() {
        return objectId;
    }

    public void setObjectId(UUID objectId) {
        this.objectId = objectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getOfferId() {
        return offerId;
    }

    public void setOfferId(UUID offerId) {
        this.offerId = offerId;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyID) {
        this.companyId = companyID;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public UUID[] getPrivateCompanyIds() {
        return privateCompanyIds;
    }

    public void setPrivateCompanyIds(UUID[] privateCompanyIds) {
        this.privateCompanyIds = privateCompanyIds;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalCountryIso() {
        return originalCountryIso;
    }

    public void setOriginalCountryIso(String originalCountryIso) {
        this.originalCountryIso = originalCountryIso;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductionMethod() {
        return productionMethod;
    }

    public void setProductionMethod(String productionMethod) {
        this.productionMethod = productionMethod;
    }

    public int getGlazing() {
        return glazing;
    }

    public void setGlazing(int glazing) {
        this.glazing = glazing;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Request createRequest() {
        return new Request(
                this.getObjectId(),
                this.getCode(),
                this.getOfferId(),
                this.getOwnerId(),
                this.getCompanyId(),
                this.isAccepted(),
                this.getPrivateCompanyIds(),
                this.getCategory(),
                this.getScientificName(),
                this.getName(),
                this.getOriginalCountryIso(),
                this.getDescription(),
                this.getProductionMethod(),
                this.getGlazing(),
                this.getCurrency(),
                this.getCreatedAt(),
                this.getUpdatedAt()
        );
    }
}
