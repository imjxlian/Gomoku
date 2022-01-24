/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Exceptions.InvalidCoordinatesException;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jforme/tduthil
 */
public class PositionNGTest {

    /**
     * Test of getCol method, of class Position.
     * @throws Exceptions.InvalidCoordinatesException
     */
    @Test
    public void testGetCol() throws InvalidCoordinatesException {
        System.out.println("getCol");
        Position instance = new Position(3,4);
        int expResult = 3;
        int result = instance.getCol();
        assertEquals(result, expResult);
        
        System.out.println("getColLettre");
        int expResultLettre = 0;
        int resultLettre = Position.colToInt("A14");
        assertEquals(resultLettre, expResultLettre);
 
    }

    /**
     * Test of getLig method, of class Position.
     * @throws Exceptions.InvalidCoordinatesException
     */
    @Test
    public void testGetLig() throws InvalidCoordinatesException {
        
        System.out.println("getRow");
        Position instance = new Position(3,4);
        int expResult = 4;
        int result = instance.getRow();
        assertEquals(result, expResult);
        
        System.out.println("getRowLettre");
        int expResultLettre = 12;
        int resultLettre = Position.rowToInt("A13");
        assertEquals(resultLettre, expResultLettre);
       
    }
    
    @Test(expectedExceptions = InvalidCoordinatesException.class)
    public void testGetLigExcept() throws InvalidCoordinatesException {       
        System.out.println("getRowException");
        Position instanceErreur = new Position("A0");
        
        System.out.println("getRowException2");
        Position instanceErreur2 = new Position("A27");
    }
    
}
