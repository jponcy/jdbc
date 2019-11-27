package com.tactfactory.ovg.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "app_customers")
public class Customer extends EntityBase {

    @NotBlank
    @Column(nullable = false)
    private String lastname;

    @NotBlank
    @Column(nullable = false)
    private String firstname;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    private final List<RendezVous> rendezVous = new ArrayList<>();

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the rendezVous
     */
    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void addRendezVous(final RendezVous rdv) {
        if (!this.rendezVous.contains(rdv)) {
            this.rendezVous.add(rdv);
        }
    }

    public void removeRendezVous(final RendezVous rdv) {
        if (this.rendezVous.contains(rdv)) {
            this.rendezVous.remove(rdv);
        }
    }
}
