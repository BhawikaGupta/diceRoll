package com.great.learning.dice.roll;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RankBoard {
    Map<String, Integer> rankMap;
    int startingRank;

    public RankBoard() {
        this.rankMap = new HashMap<>();
        startingRank = 1;
    }

    public void addScore(String playerId, int score) {
        rankMap.put(playerId, score);
    }

    public void displayRankBoard() {
        int currentStartingRank = startingRank;
        Map<String, Integer> sortedRankMap = rankMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("*******  Rank Board ********");
        System.out.println("Player Id" + " Score" + " Rank");
        for(String playerId: sortedRankMap.keySet()) {
            System.out.println(playerId + "    " + sortedRankMap.get(playerId) + "    " + currentStartingRank++);
        }


    }

    public int getRank(String playerId) {
        rankMap.remove(playerId);
        return startingRank++;
    }
}
