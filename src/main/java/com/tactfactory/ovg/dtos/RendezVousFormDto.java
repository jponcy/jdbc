package com.tactfactory.ovg.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class RendezVousFormDto {
    @NotNull
    private LocalDateTime startedAt;

    private boolean toInstall;

    private long customerId;

    private long employeeId;

    private long productId;

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
     * @return the customerId
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the employeeId
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the productId
     */
    public long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

}
