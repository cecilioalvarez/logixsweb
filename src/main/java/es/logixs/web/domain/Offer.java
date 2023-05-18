package es.logixs.web.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Offer {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "objectId")
    private UUID objectId;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;

    public Offer(UUID objectId, String code, String name, String description, String category) {
        this.objectId = objectId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Offer(UUID objectId) {
        this.objectId = objectId;
    }

    public Offer() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer offers)) return false;
        return Objects.equals(objectId, offers.objectId) && Objects.equals(code, offers.code);
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
