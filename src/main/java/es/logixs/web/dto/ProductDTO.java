package es.logixs.web.dto;

import es.logixs.web.domain.Product;

public class ProductDTO {
  private String objectId;
  private String userId;
  private String code;
  private String companyId;
  private String scientificName;
  private String name;
  private String category;
  private String originCountryIso;
  private String quality;
  private String descAndSpecs;

  public ProductDTO() {
  }

  public ProductDTO(String objectId, String userId, String code, String companyId, String scientificName, String name, String category, String originCountryIso, String quality, String descAndSpecs) {
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
  }

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
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

  public Product createProduct() {
    return new Product(this.getObjectId(), this.getUserId(), this.getCode(), this.getCompanyId(), this.getScientificName(), this.getName(), this.getCategory(), this.getOriginCountryIso(), this.getQuality(), this.getDescAndSpecs());
  }
}
