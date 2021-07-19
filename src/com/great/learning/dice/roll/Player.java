package com.great.learning.dice.roll;

import java.util.*;

public class Player {
    String name;
    int score;
    boolean shouldPlay;
    List<Integer> moves;

    public Player(String name) {
        this.name = name;
        this.moves = new LinkedList<>();
        this.score = 0;
        this.shouldPlay = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMoves() {
        return moves;
    }

    public void addMove(Integer move) {
        this.moves.add(move);
    }

    public void setMoves(List<Integer> moves) {
        this.moves = moves;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean shouldPlay() {
        return shouldPlay;
    }

    public void setShouldPlay(boolean shouldPlay) {
        this.shouldPlay = shouldPlay;
    }
}
