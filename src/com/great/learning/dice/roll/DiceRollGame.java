package com.great.learning.dice.roll;

import java.util.*;

public class DiceRollGame {
    private int N;
    private int maxScore;
    private Queue<Player> players;
    private Scanner sc;
    private RankBoard rankBoard;

    public void initGame(int N, int  M) {
        this.N = N;
        this.maxScore = M;
        this.players = new LinkedList<>();
        this.rankBoard = new RankBoard();
        this.sc = new Scanner(System.in);
        for(int i=1; i<=N; i++) {
            Player player = new Player("Player" + "-" + i);
            players.add(player);
            rankBoard.addScore(player.getName(), 0);
        }
        Collections.shuffle((List<?>) players); //random order to roll the dice
    }

    private boolean hasPlayerWon(Player player) {
        if(player.getScore() >= maxScore) {
            return true;
        }
        return false;
    }

    public void startGame() {
        while (players.size() > 0) {
            Player currentPlayer = players.poll();
            rollDice(currentPlayer);
            rankBoard.displayRankBoard();
            if(hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " you have completed the game and your rank is: " + rankBoard.getRank(currentPlayer.getName()));
            }
            else {
                players.add(currentPlayer);
            }
        }
    }

    private void rollDice(Player player) {
        if(player.shouldPlay()) {
            System.out.println(player.getName() + " its your turn (press ‘r’ to roll the dice)");
            if (sc.next().equals("r")) {
                int diceRollValue = DiceService.roll();
                player.setScore(player.getScore()+diceRollValue);
                player.addMove(diceRollValue);
                rankBoard.addScore(player.getName(), player.getScore());
                checkSkipMove(player);
                System.out.println(player.getName() + " you rolled " + diceRollValue + ". Your current score is " + player.getScore());
                if(diceRollValue == 6 && player.getScore() < maxScore) {
                    System.out.println(player.getName() + " you rolled six. You will get another chance");
                    rollDice(player);
                }
            }
            else {
                System.out.println("Invalid input. Try again");
                rollDice(player);
            }
        }
        else {
            System.out.println(player.getName() + " your chance will be skipped. You rolled two ones's in last two moves");
            player.setShouldPlay(true);
        }
    }

    private void checkSkipMove(Player player) {
        int movesSize = player.getMoves().size();
        if(movesSize>=2) {
            if(player.getMoves().get(movesSize-1) == 1 && player.getMoves().get(movesSize-2) ==1) {
                player.setShouldPlay(false);
            }
        }
    }
}
