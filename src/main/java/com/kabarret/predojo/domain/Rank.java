package com.kabarret.predojo.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rank {

    private Map<String, List<UserRank>> matchUserRank = new HashMap<String, List<UserRank>>();

    public Map<String, List<UserRank>> getMatchUserRank() {
        return matchUserRank;
    }

    public void setMatchUserRank(Map<String, List<UserRank>> matchUserRank) {
        this.matchUserRank = matchUserRank;
    }
}
