package com.great.learning.dice.roll;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        DiceRollGame diceRollGame = new DiceRollGame();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int n = sc.nextInt();
        System.out.println("Enter the score: ");
        int m = sc.nextInt();
        diceRollGame.initGame(n, m);
        diceRollGame.startGame();
    }
}
