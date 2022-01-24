/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jforme/tduthil
 */
public class Game {

    public static Color nextPlayer;
    public static Board board;
    public static int nbToWin = 5;
    public static int tour = 0;
    public static ArrayList<Position> coupsjoues = new ArrayList();

    /**
     * Méthode permettant de savoir si le coup du joueur est valide
     * @param p, la Position jouée
     * @return true si valide, false sinon.
     */
    public static boolean play(Position p) {
        if (tour < 1) {
            return isInBoard(p) && isFree(p);
        } else {
            return isFree(p) && isInBoard(p) && isAdj(p);
        }
    }

    /**
     * Méthode permettant de vérifier que le joueur pose sur une case vide
     *
     * @param p, la position à vérifier
     * @return true si la Position est Libre, false sinon
     */
    public static boolean isFree(Position p) {
        if (isInBoard(p)) {
            return Color.NONE == board.color[p.col][p.row];
        } else {
            return false;
        }
    }

    /**
     * Méthode permettant de vérifier que la position est bien dans le plateau.
     *
     * @param p, la position à vérifier.
     * @return true si la Position est dans le plateau, faux sinon.
     */
    public static boolean isInBoard(Position p) {
        return p.col >= 0 && p.col < board.nb_colonnes && p.row >= 0 && p.row < board.nb_lignes;
    }

    /**
     * Méthode permettant de vérifier que la postion est bien adjacente à une
     * Position. alliées.
     *
     * @param p, la position à vérifier
     * @return true si la Position est adjacente à une autre, faux sinon.
     */
    public static boolean isAdj(Position p) {
        boolean isAdj = false;
        Position adj[] = Position.PositionAdj(p);
        for (int f = 0; f < 8; f++) {
            if (isInBoard(adj[f])) {
                if (board.color[adj[f].col][adj[f].row] != Color.NONE) {
                    isAdj = true;
                }
            }
        }
        return isAdj;
    }
    /**
     * Méthode pour savoir si il y a un gagnant.
     * @return true si une de ces trois conditions de victoires est vérifié
     */
    public static boolean isWin() {
        return board.rowComplete() || board.colComplete() || board.diagComplete();
    }
    
    /**
     * Méthode déterminant tous les coups jouables
     * @param b, le Board
     * @return un tableau de Position des coups jouables
     */
    public static Position[] coupsJouables(Board b){
        Position[] coupsJouables = new Position[676];
        int n = 0;
        for(int i = 0; i < board.nb_lignes; i++){
            for(int u = 0; u < board.nb_colonnes; u++){
                Position p = new Position(u,i);
                if(board.color[u][i] == Color.NONE && Game.tour < 1){;
                    coupsJouables[n] = p;
                    n++;
                } else if(Game.isAdj(p) && Game.isFree(p)){
                    coupsJouables[n] = p;
                    n++;
                }
            }
        }
        return Arrays.copyOf(coupsJouables, n);
    }

    /**
     * Méthode affichant les coups jouées lors de la partie
     */
    public static void afficherCoupsJoues() {
        System.out.print("Listes des " + coupsjoues.size() + " coups joués : ");
        for (Position p : coupsjoues) {
            System.out.print(Position.positionToString(p) + " ");
        }
    }
    

}
