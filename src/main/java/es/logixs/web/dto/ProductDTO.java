package es.logixs.web.dto;

import es.logixs.web.domain.Product;

import java.util.Date;
import java.util.UUID;

public class ProductDTO {
  private UUID objectId;
  private String userId;
  private String code;
  private String companyId;
  private String scientificName;
  private String name;
  private String category;
  private String originCountryIso;
  private String quality;
  private String descAndSpecs;
  private double glazing;
  private String productionMethod;
  private String packing;
  private String description;
  private Date createdAt;
  private Date updatedAt;


  public ProductDTO() {
  }

  public ProductDTO(UUID objectId, String userId, String code, String companyId, String scientificName, String name, String category, String originCountryIso, String quality, String descAndSpecs, double glazing, String productionMethod, String packing, String description, Date createdAt, Date updatedAt) {
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

  public ProductDTO(Product product) {
    this.objectId = product.getObjectId();
    this.userId = product.getUserId();
    this.code = product.getCode();
    this.companyId = product.getCompanyId();
    this.scientificName = product.getScientificName();
    this.name = product.getName();
    this.category = product.getCategory();
    this.originCountryIso = product.getOriginCountryIso();
    this.quality = product.getQuality();
    this.descAndSpecs = product.getDescAndSpecs();
    this.glazing = product.getGlazing();
    this.productionMethod = product.getProductionMethod();
    this.packing = product.getPacking();
    this.description = product.getDescription();
    this.createdAt = product.getCreatedAt();
    this.updatedAt = product.getUpdatedAt();
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

  public Product createProduct() {
    return new Product(this.getObjectId(), this.getUserId(), this.getCode(), this.getCompanyId(), this.getScientificName(), this.getName(), this.getCategory(), this.getOriginCountryIso(), this.getQuality(), this.getDescAndSpecs(), this.getGlazing(), this.getProductionMethod(), this.getPacking(), this.getDescription(), this.getCreatedAt(), this.getUpdatedAt());
  }
}
