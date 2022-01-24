/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Jeu.Board;
import Jeu.Game;
import Exceptions.InvalidCoordinatesException;
import Jeu.Match;
import Jeu.Position;
import java.util.Scanner;

/**
 *
 * @author jforme/tduthil
 */
public class HumanPlayer implements Player {

    static Scanner in = new Scanner(System.in);
    public String username;

    /**
     * Constructeur de la classe HumanPlayer
     *
     * @param username, le surnom du joueur
     */
    public HumanPlayer(String username) {
        this.username = username;
    }

    /**
     * Méthode permettant d'obtenir le nom du joueur
     *
     * @return le surnom du joueur
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Méthode demandant au joueur la Position choisit
     *
     * @param b, le Board, sur lequelle on joue
     * @return la Position choisit par le joueur
     */
    @Override
    public Position choice(Board b) {
        Position p = null;
        p = writeCoordinates(b);
        b.set(p, Game.nextPlayer);
        return p;
    }

    /**
     * Méthode permettant de vérifier que la Position choisit, soit libre, dans
     * le plateau et soit adjancente à une autre.
     *
     * @param b, le Board sur lequelle on joue
     * @return la Position
     */
    Position writeCoordinates(Board b) {
        Position p = null;
        boolean continuer = false;
        do {
            System.out.println("> Quel coup voulez-vous jouer " + this.username + " ?");
            try {
                p = readCoordinates(b);
                continuer = Game.play(p);
                if (!Game.isInBoard(p)) {
                    System.out.println("");
                    System.out.println("Erreur : Max colonnes = " + Position.colonneToString(b.nb_colonnes - 1));
                    System.out.println("Erreur : Max lignes = " + b.nb_lignes);
                    System.out.println("");
                }
            } catch (InvalidCoordinatesException ex) {
                System.out.println("");
            }

        } while (!continuer);
        return p;
    }

    /**
     * Méthode permettant de lire le choix du joueur.
     *
     * @param b, Board sur lequelle on joue
     * @return la Position choisit
     * @throws InvalidCoordinatesException
     */
    Position readCoordinates(Board b) throws InvalidCoordinatesException {
        String coupSaisi;
        Position p;
        coupSaisi = in.nextLine();
        if ("/quit".equals(coupSaisi)) {
            System.out.println("> " + username + " a quitté la partie.");
            System.exit(0);

        }
        p = new Position(coupSaisi);
        return p;
    }

    /**
     * Méthode permettant au joueur de choisir un surnom.
     */
    @Override
    public void initUsername() {
        boolean continuer;
        do {
            if (Match.joueur1.getUsername().length() == 0) {
                System.out.println("> Comment s'appelle le joueur 1 ?");
            } else {
                if (Match.joueur2.getUsername().equals(Match.joueur1.getUsername())) {
                    System.out.println();
                    System.out.println("Erreur : Cet utilisateur existe déjà");
                    System.out.println();
                }
                System.out.println("> Comment s'appelle le joueur 2 ?");
            }
            username = in.nextLine();
            if ("/quit".equals(username)) {
                System.out.println("> " + username + " a quitté la partie.");
                System.exit(0);

            }
            continuer = username.length() == 0 || username.trim().equals("") || Match.joueur2.getUsername().equals(Match.joueur1.getUsername());
        } while (continuer);
    }

}
