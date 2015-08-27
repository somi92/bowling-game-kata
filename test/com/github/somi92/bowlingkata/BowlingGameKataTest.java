/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.somi92.bowlingkata;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author milos
 */
public class BowlingGameKataTest {
    
   private Game game;
    
   @Before
   public void setUp() throws Exception {
       game = new Game();
   }
   
   private void rollMany(int n, int pins) {
        for(int i=0; i<n; i++) {
            game.roll(pins);
        }
    }
   
   @Test
   public void gutterGameTest() throws Exception {
       rollMany(20, 0);
       assertEquals(0, game.score());
   }
   
   @Test
   public void allOnesTest() throws Exception {
       rollMany(20, 1);
       assertEquals(20, game.score());
   }
   
   @Test
   public void oneSpareTest() throws Exception {
        rollSpare();
       game.roll(3);
       rollMany(17, 0);
       assertEquals(16, game.score());
   }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
    
    @Test
    public void oneStrikeTest() throws Exception {
        rollStrike(); 
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }
    
    @Test
    public void perfectGameTest() throws Exception {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }
}
