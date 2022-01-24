package Jeu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jforme/tduthil
 */
public class BoardNGTest {
    Board b = new Board(10,20);

    /**
     * Test of get method, of class Board.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Position p = new Position(1, 1);
        Color expResult = Color.NONE;
        Color result = b.get(p);
        assertEquals(result, expResult);
    }

    /**
     * Test of set method, of class Board.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Position p = new Position(2, 2);
        Color c = Color.WHITE;
        b.set(p, c);
        assertEquals(b.get(p),c);
    }

    /**
     * Test of dessinerLigne method, of class Board.
     */
    @Test
    public void testDessinerLigne() {
        System.out.println("dessinerLigne");
        b.dessinerLigne();

    }

    /**
     * Test of dessinerLettreHaut method, of class Board.
     */
    @Test
    public void testDessinerLettreHaut() {
        System.out.println("dessinerLettreHaut");
        b.dessinerLettreHaut();

    }

    /**
     * Test of dessinerBoard method, of class Board.
     */
    @Test
    public void testDessinerBoard() {
        System.out.println("dessinerBoard");
        b.dessinerIntérieurBoard();
    }

    /**
     * Test of dessiner method, of class Board.
     */
    @Test
    public void testDessiner() {
        System.out.println("dessiner");
        b.dessiner();
    }

}
