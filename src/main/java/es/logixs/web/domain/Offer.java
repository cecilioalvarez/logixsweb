package es.logixs.web.domain;

import java.util.Objects;

public class Offer {

    private String objectId;
    private String code;
    private String name;
    private String description;
    private String category;

    public Offer(String objectId, String code, String name, String description, String category) {
        this.objectId = objectId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Offer(String objectId) {
        this.objectId = objectId;
    }

    public Offer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer offers)) return false;
        return Objects.equals(objectId, offers.objectId) && Objects.equals(code, offers.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, code);
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


}
