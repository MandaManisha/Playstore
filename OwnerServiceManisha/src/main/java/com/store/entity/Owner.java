package com.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerid; // Use Long to match your service layer and repository

    @Column(length = 20, nullable = false)
    private String ownername;

    @Column(length = 50, nullable = false, unique = true) // Adjusted length for emails
    private String owneremail;

    @Column(length = 20, nullable = false)
    private String ownerpassword;

    // Getters and Setters
    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getOwneremail() {
        return owneremail;
    }

    public void setOwneremail(String owneremail) {
        this.owneremail = owneremail;
    }

    public String getOwnerpassword() {
        return ownerpassword;
    }

    public void setOwnerpassword(String ownerpassword) {
        this.ownerpassword = ownerpassword;
    }

    @Override
    public String toString() {
        return "Owner [ownerid=" + ownerid + ", ownername=" + ownername + ", owneremail=" + owneremail
                + ", ownerpassword=" + ownerpassword + "]";
    }
}
