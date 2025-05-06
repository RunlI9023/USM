package com.kalimid.usm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long ID;
    private String name;
    private List<String> subscriptions;

    public User() {
    }

    public User(Long ID, String name, List<String> subscriptions) {
        this.ID = ID;
        this.name = name;
        this.subscriptions = subscriptions;
    }
    
    public User(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    public User(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<String> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
