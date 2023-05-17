package es.logixs.web.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Type(type="uuid-char")
    @Column(name = "objectId")
    private UUID objectId;
    @Column(name = "userId")
    private String userId;
    private String code;
    @Column(name = "companyId")
    private String companyId;
    @Column(name = "scientificName")
    private String scientificName;
    private String name;
    private String category;
    @Column(name = "originCountryIso")
    private String originCountryIso;
    private String quality;
    @Column(name = "descAndSpecs")
    private String descAndSpecs;
    private double glazing;
    @Column(name = "productionMethod")
    private String productionMethod;
    private String packing;
    private String description;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;
    public Product() {

    }

    public Product(UUID objectId) {
        this.objectId = objectId;
    }

    public Product(UUID objectId, String userId, String code, String companyId, String scientificName, String name, String category, String originCountryIso, String quality, String descAndSpecs, double glazing, String productionMethod, String packing, String description, Date createdAt, Date updatedAt) {
        this.objectId = objectId;
        this.userId = userId;
        this.code = code;
        this.companyId = companyId;
        this.scientificName = scientificName;
        this.name = name;
        this.category = category;
        this.originCountryIso = originCountryIso;
        this.quality = quality;
        this.descAndSpecs = descAndSpecs;
        this.glazing = glazing;
        this.productionMethod = productionMethod;
        this.packing = packing;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String userId, String code, String companyId, String scientificName, String name, String category, String originCountryIso, String quality, String descAndSpecs, double glazing, String productionMethod, String packing, String description, Date createdAt, Date updatedAt) {
        this.userId = userId;
        this.code = code;
        this.companyId = companyId;
        this.scientificName = scientificName;
        this.name = name;
        this.category = category;
        this.originCountryIso = originCountryIso;
        this.quality = quality;
        this.descAndSpecs = descAndSpecs;
        this.glazing = glazing;
        this.productionMethod = productionMethod;
        this.packing = packing;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getObjectId() {
        return objectId;
    }

    public void setObjectId(UUID objectId) {
        this.objectId = objectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOriginCountryIso() {
        return originCountryIso;
    }

    public void setOriginCountryIso(String originCountryIso) {
        this.originCountryIso = originCountryIso;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDescAndSpecs() {
        return descAndSpecs;
    }

    public void setDescAndSpecs(String descAndSpecs) {
        this.descAndSpecs = descAndSpecs;
    }

    public double getGlazing() {
        return glazing;
    }

    public void setGlazing(double glazing) {
        this.glazing = glazing;
    }

    public String getProductionMethod() {
        return productionMethod;
    }

    public void setProductionMethod(String productionMethod) {
        this.productionMethod = productionMethod;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
