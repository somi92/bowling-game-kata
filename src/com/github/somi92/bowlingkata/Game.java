/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.somi92.bowlingkata;

/**
 *
 * @author milos
 */
public class Game {
    
    private int[] rolls = new int[21];
    private int currentRoll = 0;
    
    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int rollCount = 0;
        for(int frame=0; frame<10; frame++) {
            if(isStrike(rollCount)) { 
                score += 10 + nextTwoBallsForStrike(rollCount);
                rollCount++;
            } else if(isSpare(rollCount)) { 
                score += 10 + nextBallForSpare(rollCount);
                rollCount += 2;
            } else {
                score += twoBallsInFrame(rollCount);
                rollCount += 2;
            }
        }
        return score;
    }

    private int twoBallsInFrame(int rollCount) {
        return rolls[rollCount] + rolls[rollCount+1];
    }

    private int nextBallForSpare(int rollCount) {
        return rolls[rollCount+2];
    }

    private boolean isStrike(int rollCount) {
        return rolls[rollCount] == 10;
    }

    private boolean isSpare(int rollCount) {
        return rolls[rollCount] + rolls[rollCount+1] == 10;
    }
    
    private int nextTwoBallsForStrike(int rollCount) {
        return rolls[rollCount+1] + rolls[rollCount+2];
    }
    
}
