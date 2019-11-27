package com.tactfactory.ovg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "app_rdv")
public class RendezVous extends EntityBase {
    private LocalDateTime startedAt;

    /** Le livreur doit-il installer le materiel. */
    @Column(nullable = false)
    private boolean toInstall = false;

    /** La personne livree. */
    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false)
    private Employee deliveryMan;

    /** Le produit a livrer (une livraison = 1 produit). */
    @ManyToOne(optional = false)
    private Product product;

    /**
     * @return the startedAt
     */
    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    /**
     * @param startedAt the startedAt to set
     */
    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the deliveryMan
     */
    public Employee getDeliveryMan() {
        return deliveryMan;
    }

    /**
     * @param deliveryMan the deliveryMan to set
     */
    public void setDeliveryMan(Employee deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    /**
     * @return the toInstall
     */
    public boolean isToInstall() {
        return toInstall;
    }

    /**
     * @param toInstall the toInstall to set
     */
    public void setToInstall(boolean toInstall) {
        this.toInstall = toInstall;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

}
