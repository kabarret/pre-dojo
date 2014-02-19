package com.kabarret.predojo.domain;

import java.util.Date;

public class Kill  {

    private User user;
    private User userKilled;
    private String weapon;
    private Date time;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserKilled() {
        return userKilled;
    }

    public void setUserKilled(User userKilled) {
        this.userKilled = userKilled;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
