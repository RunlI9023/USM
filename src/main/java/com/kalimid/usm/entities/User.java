package com.kalimid.usm.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long ID;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private List<UserSubscriptions> subscriptions = new ArrayList<UserSubscriptions>();

    public User() {
    }

    public User(Long ID, String name, List<UserSubscriptions> subscriptions) {
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

    public List<UserSubscriptions> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<UserSubscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
