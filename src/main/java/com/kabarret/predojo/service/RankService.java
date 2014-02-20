package com.kabarret.predojo.service;

import com.kabarret.predojo.domain.Kill;
import com.kabarret.predojo.domain.LogLine;
import com.kabarret.predojo.domain.Match;
import com.kabarret.predojo.domain.Rank;
import com.kabarret.predojo.domain.User;
import com.kabarret.predojo.domain.UserRank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankService {

    private Rank rank = new Rank();

    public Rank buildRank(File logFile) throws IOException {
        List<LogLine> logLines = new LoggerReaderService().fileLogReader(logFile);
        List<Match> matches = new MatchService().buildMatches(logLines);
        return buildRank(matches);
    }

    public Rank buildRank(List<Match> matches){
        for (Match match : matches) {
            List<UserRank> rankMatches = new ArrayList<UserRank>();
            for (Kill kill : match.getKillList()) {
                addKill(rankMatches, kill);
                addDeath(rankMatches, kill);
            }
            rankUser(rankMatches);
            rank.getMatchUserRank().put(match.getId(), rankMatches);
        }

        return rank;
    }

    private void rankUser(List<UserRank> rankMatches) {
        Collections.sort(rankMatches);
    }

    private void addKill(List<UserRank> rankMatches, Kill kill) {
        UserRank killerUser = getUserRank(rankMatches, kill.getUser());
        killerUser.addKill(kill.getWeapon(), kill.getTime());
    }

    private void addDeath(List<UserRank> rankMatches, Kill kill) {
        UserRank deadUser  = getUserRank(rankMatches, kill.getUserKilled());
        deadUser.addDead(kill.getTime());
    }

    private UserRank getUserRank(List<UserRank> rankMatches, User user) {
        UserRank matchUserRank = null;
        for (UserRank rankMatch : rankMatches) {
            if(rankMatch.getUser().equals(user)){
                matchUserRank = rankMatch;
                break;
            }
        }

        if(matchUserRank == null){
            matchUserRank = new UserRank(user);
            rankMatches.add(matchUserRank);
        }
        return matchUserRank;
    }
}
