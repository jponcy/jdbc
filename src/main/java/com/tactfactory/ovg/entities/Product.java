package com.tactfactory.ovg.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "app_products")
public class Product extends EntityBase {
    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private float price;

    @OneToMany(mappedBy = "product")
    private final List<RendezVous> deliveries = new ArrayList<>();

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the diliveries
     */
    public List<RendezVous> getDiliveries() {
        return this.deliveries;
    }

    public void addDelivery(final RendezVous delivery) {
        if (!this.deliveries.contains(delivery)) {
            this.deliveries.add(delivery);
        }
    }

    public void removeDelivery(final RendezVous delivery) {
        if (this.deliveries.contains(delivery)) {
            this.deliveries.remove(delivery);
        }
    }
}
