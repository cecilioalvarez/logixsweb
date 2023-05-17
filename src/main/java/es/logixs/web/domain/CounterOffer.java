package es.logixs.web.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class CounterOffer {
    @Id
    @Type(type="uuid-char")
    @Column(name = "objectId")
    private UUID objectId;
    private String name;
    private String vom;
    @Column(name = "originalPrice")
    private double originalPrice;
    @Column(name = "counterOfferPrice")
    private double counterOfferPrice;
    private double quantity;

    public CounterOffer() {

    }

    public CounterOffer(UUID objectId) {
        this.objectId = objectId;
    }

    public CounterOffer(UUID objectId, String name, String vom, double originalPrice, double counterOfferPrice, double quantity) {
        this.objectId = objectId;
        this.name = name;
        this.vom = vom;
        this.originalPrice = originalPrice;
        this.counterOfferPrice = counterOfferPrice;
        this.quantity = quantity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterOffer that = (CounterOffer) o;
        return Double.compare(that.originalPrice, originalPrice) == 0 && Double.compare(that.counterOfferPrice, counterOfferPrice) == 0 && Double.compare(that.quantity, quantity) == 0 && Objects.equals(objectId, that.objectId) && Objects.equals(name, that.name) && Objects.equals(vom, that.vom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, name, vom, originalPrice, counterOfferPrice, quantity);
    }
}