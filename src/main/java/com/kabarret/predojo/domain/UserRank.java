package com.kabarret.predojo.domain;

import java.util.HashMap;
import java.util.Map;

public class UserRank implements Comparable<UserRank>{

    private User user;
    private Integer killCount;
    private Integer deathsCount;
    private Map<String, Integer> weaponsKills;

    public UserRank(User user) {
        this.user = user;
        this.killCount = 0;
        this.deathsCount = 0;
        this.weaponsKills = new HashMap<String, Integer>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getKillCount() {
        return killCount;
    }

    public void setKillCount(Integer killCount) {
        this.killCount = killCount;
    }

    public Integer getDeathsCount() {
        return deathsCount;
    }

    public void setDeathsCount(Integer deathsCount) {
        this.deathsCount = deathsCount;
    }

    public Map<String, Integer> getWeaponsKills() {
        return weaponsKills;
    }

    public void setWeaponsKills(Map<String, Integer> weaponsKills) {
        this.weaponsKills = weaponsKills;
    }

    public void addKill(String weapon){
        this.killCount ++;
        Integer killsOfWeapon = 1;
        if (weaponsKills.get(weapon) != null){
            killsOfWeapon += weaponsKills.get(weapon);
            weaponsKills.remove(weapon);

        };
        weaponsKills.put(weapon, killsOfWeapon);
    }

    public void addDead(){
        this.deathsCount ++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRank that = (UserRank) o;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return true;
    }

    @Override
    public int compareTo(UserRank o) {
        int comparator = o.getKillCount().compareTo(this.getKillCount());
        if(comparator == 0){
            comparator = o.getDeathsCount().compareTo(this.getDeathsCount());
        }
        return comparator;
    }
}