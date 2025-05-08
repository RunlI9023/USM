package com.kalimid.usm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="subscriptions")
public class UserSubscriptions {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long subID;
    private String name;

    public UserSubscriptions() {
    }
    
    public UserSubscriptions(Long subID, String name) {
        this.subID = subID;
        this.name = name;
    }

    public Long getSubID() {
        return subID;
    }

    public void setSubID(Long subID) {
        this.subID = subID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
