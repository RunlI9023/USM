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
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long sub_id;
    private String subName;
    private Sub sub;
    public enum Sub {YOUTUBE_PREMIUN, VK_MUSIC, NETFLIX, YANDEX_PLUS};

    public UserSubscriptions() {
    }

    public UserSubscriptions(Long sub_id, String subName, Sub sub) {
        this.sub_id = sub_id;
        this.subName = subName;
        this.sub = sub;
    }

    public UserSubscriptions(String subName) {
        this.subName = subName;
    }

    public Long getSubId() {
        return sub_id;
    }

    public void setId(Long sub_id) {
        this.sub_id = sub_id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Sub getSub() {
        return sub;
    }

    public void setSub(Sub sub) {
        this.sub = sub;
    }
}
