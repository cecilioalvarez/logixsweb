package es.logixs.web.domain;

public class Product {
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

    public Product() {

    }

    public Product(String userId, String code, String companyId, String scientificName, String name, String category, String originCountryIso, String quality, String descAndSpecs) {
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

    public Product(String objectId) {
        this.objectId = objectId;
    }

    public Product(String objectId, String userId, String code, String companyId, String scientificName, String name, String category, String originCountryIso, String quality, String descAndSpecs) {
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

    @Override
    public String toString() {
        return "Products{" +
            "objectId='" + objectId + '\'' +
            ", userId='" + userId + '\'' +
            ", code='" + code + '\'' +
            ", companyId='" + companyId + '\'' +
            ", scientificName='" + scientificName + '\'' +
            ", name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", originCountryIso='" + originCountryIso + '\'' +
            ", quality='" + quality + '\'' +
            ", descAndSpecs='" + descAndSpecs + '\'' +
            '}';
    }
}
