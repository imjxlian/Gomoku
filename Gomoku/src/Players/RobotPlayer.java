/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Jeu.Board;
import Jeu.Game;
import Exceptions.InvalidCoordinatesException;
import Jeu.Position;
import java.util.Random;

/**
 *
 * @author jforme/tduthil
 */
public class RobotPlayer implements Player {
    
    public String username;
    
    /**
     * Constructeur de la classe RobotPlayer
     * @param username, le surnom du Robot
     */
    public RobotPlayer(String username) {
        this.username = username;
    }
    
    /**
     * Méthode permettant d'obtenir le nom du joueur
     * @return le surnom du joueur
     */
    @Override
    public String getUsername() {
        return username;
    }
    
    /**
     * Méthode demandant au joueur la Position choisit
     * @param b, le Board, sur lequelle on joue
     * @return la Position choisit par le joueur
     */
    @Override
    public Position choice(Board b) {
        Position p = null;
        try {
            p = writeCoordinates(b);
            b.set(p, Game.nextPlayer);
            
        } catch (InvalidCoordinatesException ex) {
            System.out.println("");
        }
        
        return p;
    }
    
    /**
     * Méthode permettant de vérifier que la Position choisit, soit libre, dans le plateau
     * et soit adjancente à une autre.
     * @param b, le Board sur lequelle on joue
     * @return la Position
     * @throws InvalidCoordinatesException
     */
     Position writeCoordinates(Board b) throws InvalidCoordinatesException {
        Position p;
        Position[] coupsJouables = Game.coupsJouables(b);
        Random r = new Random();
        int n = r.nextInt(coupsJouables.length);
        p = coupsJouables[n];
        System.out.println();
        System.out.println("> " + this.username + " joue le coup : " + Position.positionToString(p));
        System.out.println();
        return p;
    }
     
    /**
     * Méthode au joueur leur surnoms durant la partie.
     */
    @Override
    public void initUsername() {
        String[] usernameList = new String[5];
        usernameList[0] = "MaxLaMenace";
        usernameList[1] = "BobLeRobot";
        usernameList[2] = "R2D2";
        usernameList[3] = "Terminator";
        usernameList[4] = "C3PO";
        Random r = new Random();
        int n = r.nextInt(usernameList.length);
        username = usernameList[n];
    }
     
}
