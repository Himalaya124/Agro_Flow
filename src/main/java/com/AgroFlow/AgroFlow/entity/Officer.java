package com.AgroFlow.AgroFlow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Officer {

    @Id
    private String officerId;
    private String name;
    private String nid;
    private String officeLocation;
    private String regionAssigned;
    private String contact;
    private String password;

    // Getters and Setters
    public String getOfficerId() { return officerId; }
    public void setOfficerId(String officerId) { this.officerId = officerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }

    public String getOfficeLocation() { return officeLocation; }
    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }

    public String getRegionAssigned() { return regionAssigned; }
    public void setRegionAssigned(String regionAssigned) { this.regionAssigned = regionAssigned; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}