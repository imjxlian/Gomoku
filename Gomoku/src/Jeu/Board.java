/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tduthil/jforme
 */
public class Board {

    public int nb_colonnes;
    public int nb_lignes;
    Color[][] color;

    /**
     * Constructeur de la classe Board
     *
     * @param nb_colonnes, le nombre de colonnes chosit par le joueur
     * @param nb_lignes, le nombre de ligne chosiit per le joueur
     */
    public Board(int nb_colonnes, int nb_lignes) {
        this.nb_colonnes = nb_colonnes;
        this.nb_lignes = nb_lignes;
        color = new Color[nb_colonnes][nb_lignes];
    }

    /**
     * Méthode permettant de connaître la couleur d'une position
     *
     * @param p, la Position
     * @return la couleur
     */
    Color get(Position p) {
        return p.color;
    }

    /**
     * Méthode permettant d'attribuer une couleur à une position
     *
     * @param p, la position
     * @param c, la couleur
     */
    public void set(Position p, Color c) {
        p.color = c;
        color[p.col][p.row] = c;
    }

    /**
     * Méthode permettant de dessiner les lignes des côtés de notre Board
     */
    void dessinerLigne() {
        System.out.print("   +");
        for (int i = 0; i <= nb_colonnes * 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    /**
     * Méthode permettant de dessiner les lettres sur le haut du Board
     */
    void dessinerLettreHaut() {
        char letter = 'A';
        System.out.print("     ");
        for (int i = 0; i < nb_colonnes; i++) {
            System.out.print(letter + " ");
            letter += 1;
        }
        System.out.println("");
    }

    /**
     * Méthode permettant d'afficher les symboles en fonction de leur Couleurs
     */
    public void dessinerIntérieurBoard() {

        // création du board + remplissage vide
        String board[][] = new String[nb_colonnes][nb_lignes];
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
        for (int i = 0; i < nb_lignes; i++) {
            int u = 0;
            if (i < 9) {
                System.out.print(" ");
            }
            // affichage des nombres sur le côté
            System.out.print(i + 1 + " | ");
            while (u < nb_colonnes) {
                if (color[u][i] == Color.BLACK) {
                    board[u][i] = "X";
                } else if (color[u][i] == Color.WHITE) {
                    board[u][i] = "O";
                }
                System.out.print(board[u][i] + " ");
                u++;
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    /**
     * Méthode permettant d'initialiser la taille du Board, en demandant aux
     * joueurs
     */
    void initBoardSize() {
        Scanner in = new Scanner(System.in);

        int entierSaisi = 0;
        boolean saisieCorrecte;
        for (int i = 0; i < 2; i++) {
            entierSaisi = 0;
            saisieCorrecte = false;
            do {
                try {
                    if (i == 0) {
                        System.out.println("> Indiquez le nombre de colonnes du plateau (entre 5 et 26 inclus).");
                    } else {
                        System.out.println("> Indiquez le nombre de lignes du plateau (entre 5 et 26 inclus).");
                    }
                    entierSaisi = in.nextInt();
                    saisieCorrecte = (entierSaisi >= 5 && entierSaisi <= 26);
                    if (!saisieCorrecte) {
                        System.out.println("> " + entierSaisi + " n'est pas compris entre 5 et 26...");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("> Saisie incorrecte, saisissez un entier compris entre 5 et 26 inclus.");
                    in.next();
                }
            } while (!saisieCorrecte);
            if (i == 0) {
                nb_colonnes = entierSaisi;
            } else {
                nb_lignes = entierSaisi;
            }
        }
    }

    /**
     * Méthode permettant d'initialiser toute les cases du Board à None
     */
    void initBoard() {
        initBoardSize();
        color = new Color[nb_colonnes][nb_lignes];
        for (Color[] col : color) {
            Arrays.fill(col, Color.NONE);
        }
    }

    /**
     * Méthode permettant de dessiner notre Board au complet
     */
    public void dessiner() {
        dessinerLettreHaut();
        dessinerLigne();
        dessinerIntérieurBoard();
        dessinerLigne();
    }

    

    /**
     * Méthode permettant de savoir si le Board, est plein
     * @return true si il n'y a plus de place, faux sinon
     */
    public boolean isFull() {
        boolean full = true;
        for (int i = 0; i < nb_colonnes; i++) {
            for (int u = 0; u < nb_lignes; u++) {
                if (color[i][u] == Color.NONE) {
                    full = false;
                }
            }
        }
        return full;
    }

    /**
     * Méthode permettant de savoir si une Ligne est complète.
     * @return true si elle est complete, faux sinon.
     */
    public boolean rowComplete() {
        Color actualColor;
        boolean isRow = false;
        int count = 0;
        for (int i = 0; i < nb_lignes; i++) {
            actualColor = null;
            count = 0;
            for (int u = 0; u < nb_colonnes; u++) {

                if (color[u][i] != Color.NONE && (null == actualColor || actualColor == color[u][i])) {
                    actualColor = color[u][i];
                    count++;
                } else {
                    if(color[u][i] == Color.NONE){
                        actualColor = null;
                        count = 0;
                    } else {
                        count = 1;
                        actualColor = color[u][i];
                    }
                }

                if (count >= Game.nbToWin) {
                    isRow = true;
                }
            }
        }
        return isRow;
    }

    /**
     * Méthode permettant de savoir si la colonne est complete.
     * @return true si elle complete, faux sinon.
     */
    public boolean colComplete() {
        Color actualColor;
        boolean isCol = false;
        int count = 0;
        for (int u = 0; u < nb_colonnes; u++) {
            actualColor = null;
            count = 0;
            for (int i = 0; i < nb_lignes; i++) {

                if (color[u][i] != Color.NONE && (null == actualColor || actualColor == color[u][i])) {
                    actualColor = color[u][i];
                    count++;
                } else {
                    if(color[u][i] == Color.NONE){
                        actualColor = null;
                        count = 0;
                    } else {
                        count = 1;
                        actualColor = color[u][i];
                    }
                }
                if (count >= Game.nbToWin) {
                    isCol = true;

                }
            }
        }
        return isCol;
    }

    /**
     * Méthode permettant de savoir si une diagonale est complete
     * @return true si elle est complete, faux sinon.
     */
    public boolean diagComplete() {
        boolean isDiag = false;
        int count = 0;
        for (int u = 0; u < nb_colonnes; u++) {
            for (int i = 0; i < nb_lignes; i++) {

                count = 0;

                Position p = new Position(u, i);
                Position diagC[] = Position.diagonalesCroissantes(p);
                Position diagD[] = Position.diagonalesDecroissantes(p);

                for (int f = 0; f < 4; f++) {
                    if (Game.isInBoard(diagC[f])) {
                        if (color[diagC[f].col][diagC[f].row] == color[u][i] && color[u][i] != Color.NONE) {
                            count++;
                        } else {
                            count = 0;
                        }
                    }
                    if (count >= 4) {
                        isDiag = true;
                    }
                }
                count = 0;

                for (int f = 0; f < 4; f++) {
                    if (Game.isInBoard(diagD[f])) {
                        if (color[diagD[f].col][diagD[f].row] == color[u][i] && color[u][i] != Color.NONE) {
                            count++;
                        } else {
                            count = 0;
                        }

                    }
                    if (count >= 4) {
                        isDiag = true;
                    }
                }

            }
        }
        return isDiag;
    }

    
}
