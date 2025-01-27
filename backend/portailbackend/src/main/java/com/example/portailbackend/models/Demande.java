package com.example.portailbackend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // type: 1 : prés et avancs salaire - 2 : changement situation financier -
    // 3: autorisation - 4: congés - 5: mutations professionels
    private String status; // : "PENDING", "APPROVED", "REJECTED"
    private String createdBy;
    private String currentApprover; // Tracks who should act next: "CHEF" or "RH"

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;


    private String details;

    public Demande() {
    }

    public Demande(Long id, String type, String status, String createdBy, String currentApprover, Date creationDate, Date lastUpdated, String details) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.createdBy = createdBy;
        this.currentApprover = currentApprover;
        this.creationDate = creationDate;
        this.lastUpdated = lastUpdated;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCurrentApprover() {
        return currentApprover;
    }

    public void setCurrentApprover(String currentApprover) {
        this.currentApprover = currentApprover;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
