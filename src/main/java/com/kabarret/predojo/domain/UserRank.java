package com.kabarret.predojo.domain;

import com.kabarret.predojo.enums.ScoreType;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRank implements Comparable<UserRank>{

    private User user;
    private Map<String, Integer> weaponsKills;
    private List<Score> scoreEvent;

    public UserRank(User user) {
        this.user = user;
        this.weaponsKills = new HashMap<String, Integer>();
        this.scoreEvent = new ArrayList<Score>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getKillCount() {
        return countScoreEvent(ScoreType.KILL);
    }


    public Integer getDeathsCount() {
        return countScoreEvent(ScoreType.DEATH);
    }

    public Map<String, Integer> getWeaponsKills() {
        return weaponsKills;
    }

    public void setWeaponsKills(Map<String, Integer> weaponsKills) {
        this.weaponsKills = weaponsKills;
    }

    public void addKill(String weapon, Date timeEvent){
        scoreEvent.add(new Score(ScoreType.KILL, timeEvent));

        Integer killsOfWeapon = 1;
        if (weaponsKills.get(weapon) != null){
            killsOfWeapon += weaponsKills.get(weapon);
            weaponsKills.remove(weapon);

        };
        weaponsKills.put(weapon, killsOfWeapon);
    }

    public void addDead(Date timeEvent){
        scoreEvent.add(new Score(ScoreType.DEATH, timeEvent));
    }

    public Integer countScoreEvent(ScoreType scoreType){
        Integer countEvent = 0;
        for (Score score : scoreEvent) {
            if(score.getScoreType().equals(scoreType)) countEvent++;
        }
        return countEvent;
    }

    public String getFavoriteWeapon(){
        Integer maxKills = 0;
        String favoriteWeapon = "";
        for (String weapon : weaponsKills.keySet()) {
            if(weaponsKills.get(weapon) > maxKills){
                maxKills =  weaponsKills.get(weapon);
                favoriteWeapon = weapon;
            }
        }

        return favoriteWeapon;
    }

    public Integer getStreak(){
        Integer maxStreak = 0;
        Integer floatScore = 0;
        for (Score score : scoreEvent) {
            if(score.getScoreType().equals(ScoreType.KILL)){
                floatScore ++;
            }
            if(score.getScoreType().equals(ScoreType.DEATH)){
                if(floatScore > maxStreak){
                    maxStreak = floatScore;
                }
                floatScore = 0;
            }
        }
        return maxStreak > floatScore ? maxStreak : floatScore;
    }


    public Boolean isPerfect(){
        if(this.getDeathsCount() == 0 && this.getKillCount() > 0 ){
            return true;
        }else{
            return false;
        }

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