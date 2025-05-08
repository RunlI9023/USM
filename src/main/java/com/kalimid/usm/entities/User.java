package com.kalimid.usm.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private List<UserSubscriptions> subscriptions;

    public User() {
    }
    
    public User(Long id, String name, List<UserSubscriptions> subscriptions) {
        this.id = id;
        this.name = name;
        this.subscriptions = subscriptions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
