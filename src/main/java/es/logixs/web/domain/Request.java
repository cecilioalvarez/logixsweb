package es.logixs.web.domain;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
@Entity
public class Request {
    @Id
    @Type(type="uuid-char")
    @Column(name = "objectId")
    private UUID objectId;
    private String code;
    @Column(name = "offerId")
    private UUID offerId;
    @Column(name = "ownerId")
    private UUID ownerId;
    @Column(name = "companyId")
    private UUID companyId;
    @Column(name = "isAccepted")
    private boolean isAccepted;
    @Column(name = "privateCompanyIds")
    private UUID[] privateCompanyIds;
    private String category;
    @Column(name = "scientificName")
    private String scientificName;
    private String name;
    @Column(name = "originalCountryIso")
    private String originalCountryIso;
    private String description;
    @Column(name = "productionMethod")
    private String productionMethod;
    private int glazing;
    private String currency;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;



    public Request(UUID objectId, String code, UUID offerId, UUID ownerId, UUID companyId, boolean isAccepted, UUID[] privateCompanyIds, String category, String scientificName, String name, String originalCountryIso, String description, String productionMethod, int glazing, String currency, Date createdAt, Date updatedAt) {
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

    public Request(UUID objectId) {
        this.objectId = objectId;
    }

    public Request() {
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
