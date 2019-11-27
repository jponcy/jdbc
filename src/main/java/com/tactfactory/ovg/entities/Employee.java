package com.tactfactory.ovg.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_employees")
@ApiModel(value = "Describes an employee for our system")
public class Employee extends EntityBase {

    @NotBlank
    @Column(nullable = false)
    @ApiModelProperty(value = "The lastname of the employee")
    private String lastname;

    @NotBlank
    @Column(nullable = false)
    @ApiModelProperty(value = "The firstname of the employee")
    private String firstname;

    @OneToMany(mappedBy = "deliveryMan")
    @JsonProperty(access = Access.READ_ONLY)
    @ApiModelProperty(value = "The list of linked appointements (deliveries, ...).", readOnly = true)
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
