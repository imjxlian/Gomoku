/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Exceptions.InvalidCoordinatesException;
import java.util.Arrays;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jforme/tduthil
 */
public class GameNGTest {

    /**
     * Test of isFree method, of class Game.
     * @throws Exceptions.InvalidCoordinatesException
     */
    @Test
    public void testIsFree() throws InvalidCoordinatesException {
        Game.board = new Board(5, 5);
        Game.board.color = new Color[Game.board.nb_colonnes][Game.board.nb_lignes];
        for (Color[] col : Game.board.color) {
            Arrays.fill(col, Color.NONE);
        }
        Position p = new Position("A1");
        Game.board.set(p, Color.BLACK);
        boolean expResult = false;
        boolean result = Game.isFree(p);
        assertEquals(result, expResult);
        
        Position p1 = new Position("B1");
        boolean expResult2 = true;
        boolean result2 = Game.isFree(p1);
        assertEquals(result2, expResult2);
        
    }

    /**
     * Test of isInBoard method, of class Game.
     * @throws Exceptions.InvalidCoordinatesException
     */
    @Test
    public void testisInBoard() throws InvalidCoordinatesException {
        Game.board = new Board(5, 5);
        Game.board.color = new Color[Game.board.nb_colonnes][Game.board.nb_lignes];
        for (Color[] col : Game.board.color) {
            Arrays.fill(col, Color.NONE);
        }
        
        Position p = new Position("A1");
        boolean expResult = true;
        boolean result = Game.isInBoard(p);
        assertEquals(result, expResult);
        
        Position p2 = new Position("A6");
        boolean expResult2 = false;
        boolean result2 = Game.isInBoard(p2);
        assertEquals(result2, expResult2);
    }

    /**
     * Test of isAdj method, of class Game.
     * @throws Exceptions.InvalidCoordinatesException
     */
    @Test
    public void testIsAdj() throws InvalidCoordinatesException {
        Game.board = new Board(5, 5);
        Game.board.color = new Color[Game.board.nb_colonnes][Game.board.nb_lignes];
        for (Color[] col : Game.board.color) {
            Arrays.fill(col, Color.NONE);
        }
        Position pTest = new Position("A1");
        Game.board.set(pTest, Color.BLACK);
        
        Position p = new Position("A2");
        boolean expResult = true;
        boolean result = Game.isAdj(p);
        assertEquals(result, expResult);
        
        Position p2 = new Position("A6");
        boolean expResult2 = false;
        boolean result2 = Game.isAdj(p2);
        assertEquals(result2, expResult2);
    }
    
}
