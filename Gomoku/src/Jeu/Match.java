/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Exceptions.InvalidSizeException;
import Players.Player;

/**
 *
 * @author tduthil/jforme
 */
public class Match {
    public static Player joueur1;
    public static Player joueur2;

    /**
     * Constructeur de la classe Match
     * @param largeur, la largeur choisit par le joueur
     * @param hauteur, la hauteur choisit par le joueur
     * @param j1, le joueur 1
     * @param j2, le joueur 2
     * @throws InvalidSizeException
     */
     Match(int largeur, int hauteur, Player j1, Player j2) throws InvalidSizeException {
        if (hauteur >= 5 && hauteur <= 26 && largeur >= 5 && largeur <= 26) {
            Game.board = new Board(largeur, hauteur);
        } else {
            throw new InvalidSizeException(hauteur, largeur);
        }
        joueur1 = j1;
        joueur2 = j2;
    }

    /**
     * Méthode permettant de lancer le jeu, de l'arrêter sous certaines conditions
     */
    public void run()  {
        boolean ended = false;
        boolean win = false;
        Game.board .initBoard();
        joueur1.initUsername();
        joueur2.initUsername();
        Game.board.dessiner();
        System.out.println();
        System.out.println("> Pour jouer il faut écrire une position de la forme 'A5', 'B12'.");
        System.out.println();
        Player j;
        do {
            if(Game.tour%2 == 0){
                Game.nextPlayer = Color.BLACK;
                j = joueur1;
            } else {
                Game.nextPlayer = Color.WHITE;
                j = joueur2;
            }
            Game.coupsjoues.add(j.choice(Game.board));
            Game.board .dessiner();
            Game.tour++;
            win = Game.isWin();
            ended = Game.board .isFull();
        } while (!win && !ended);

        if (win) {
            
            if(Game.nextPlayer == Color.BLACK){
                System.out.println();
                System.out.println("> Victoire du joueur " + joueur1.getUsername()
                    + ".");
                System.out.println();
            } else {
                System.out.println();
                System.out.println("> Victoire du joueur " + joueur2.getUsername()
                    + ".");
                System.out.println();
            } 
        } else {
            System.out.println();
            System.out.println("> Aucun joueur n'a gagné, match nul.");
            System.out.println();
            
        }
        Game.afficherCoupsJoues();
        System.out.println();
    }
}
