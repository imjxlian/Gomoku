/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Exceptions.InvalidSizeException;
import Players.RobotPlayer;
import Players.HumanPlayer;

/**
 *
 * @author jforme/tduthil
 */
public class Main {

    /**
     * Lancement du jeu
     * @param args
     * @throws InvalidSizeException
     */
    public static void main(String args[]) throws InvalidSizeException{
        Match m = new Match(5,5, new HumanPlayer(""), new RobotPlayer(""));
        m.run();
    }
}
