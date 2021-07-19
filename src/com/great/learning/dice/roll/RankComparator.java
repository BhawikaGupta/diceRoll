package com.great.learning.dice.roll;


import java.util.Comparator;
import java.util.Map;

public class RankComparator implements Comparator<String> {
    Map<String, Integer> base;

    public RankComparator(Map<String, Integer> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}