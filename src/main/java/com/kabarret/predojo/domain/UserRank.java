package com.kabarret.predojo.domain;

import java.util.List;

public class UserRank {

    private User user;
    private List<Kill> killList;

    public List<Kill> getKillList() {
        return killList;
    }

    public void setKillList(List<Kill> killList) {
        this.killList = killList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
