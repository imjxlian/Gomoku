/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Exceptions.InvalidCoordinatesException;

/**
 *
 * @author tduthil/jforme
 */
public class Position {

    final int row, col;
    Color color;

    /**
     * Constructeur de la classe Position utilisant 2 paramètres entiers.
     *
     * @param col colonne de notre plateau
     * @param row ligne de notre plateau
     */
    public Position(int col, int row) {
        this.row = row;
        this.col = col;
        this.color = Color.NONE;

    }

    /**
     * Constructeur de la classse Position utilisant 1 paramètre , une chaîne de
     * caratères.
     *
     * @param coord Position choisit par le joueur sous la forme : "A3"
     * @throws InvalidCoordinatesException
     */
    public Position(String coord) throws InvalidCoordinatesException {
        this.col = colToInt(coord);
        this.row = rowToInt(coord);
    }

    /**
     * Méthode pour obtenir seulement la colonne.
     *
     * @return la colonne du plateau
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Méthode pour obtenier seulement la ligne.
     *
     * @return la ligne du plateau
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Méthode permettant de convertir la ligne de notre chaîne de caratères en
     * vérifiant que les différentes conditions ont été respectées, sinon des
     * exceptions se levent.
     *
     * @param coord Position jouée par le joueur sous la forme : "A3"
     * @return le numéro de la ligne
     * @throws InvalidCoordinatesException
     */
    public static int rowToInt(String coord) throws InvalidCoordinatesException {

        try {
            if (coord.length() >= 2) {
                String s = String.valueOf(coord.charAt(1));
                // Si on a un nombre à 2 chiffres
                if (coord.length() > 2) {
                    s = s.concat(String.valueOf(coord.charAt(2)));
                }
                if (Integer.parseInt(s) > 26 || Integer.parseInt(s) <= 0) {
                    throw new InvalidCoordinatesException("Erreur : Position entre 1 et 26");
                }
                return Integer.parseInt(s) - 1;

            } else {
                throw new InvalidCoordinatesException("Erreur : De la forme 'A1' ou 'A15'.");
            }
        } catch (NumberFormatException exception) {
            throw new InvalidCoordinatesException("Erreur : Caractère Invalide");
        }
    }

    /**
     * Méthode permettant de convertir la colonne de notre chaîne de caratères
     * en vérifiant que les différentes conditions ont été respectées, sinon des
     * exceptions se levent.
     *
     * @param coord Position jouée par le joueur sous la forme : "A3"
     * @return le numéro de la colonne convertit.
     * @throws InvalidCoordinatesException
     */
    public static int colToInt(String coord) throws InvalidCoordinatesException {
        try {
            if (coord.length() >= 2) {
                char i = coord.charAt(0);
                return (int) i - (int) 'A';
            } else {
                throw new InvalidCoordinatesException("Erreur : De la forme 'A1' ou 'A15'.");
            }
        } catch (NumberFormatException exception) {
            throw new InvalidCoordinatesException("Erreur : Caractère Invalide");
        }
    }
    
    /**
     * Méthode convertissant un entier en un String
     * @param col, la colonne
     * @return la lettre correpond à la colonne
     */
    public static String colonneToString(int col) {
        int quot = col / 26;
        int rem = col % 26;
        char lettre = (char) ((int) 'A' + rem);
        if (quot == 0) {
            return "" + lettre;
        } else {
            return colonneToString(quot - 1) + lettre;
        }
    }

    /**
     * Méthode convertissant une Position en String
     * @param p, la Position
     * @return un String de Position
     */
    public static String positionToString(Position p) {
        String strCol = colonneToString(p.col);
        int strRow = p.row + 1;
        return strCol + strRow;
    }

    /**
     * Méthode permettant de stocker les positions des diagonales autour de notre
     * position 
     * 
     * @param p, la Position
     * @return un tableau de Position
     */
    public static Position[] diagonalesCroissantes(Position p) {
        Position[] diagonales = new Position[Game.nbToWin - 1];
        diagonales[0] = new Position(p.col + 1, p.row - 1); // NORD-EST 1
        diagonales[1] = new Position(p.col + 2, p.row - 2); // NORD-EST 2
        diagonales[2] = new Position(p.col - 1, p.row + 1); // SUD-OUEST 1
        diagonales[3] = new Position(p.col - 2, p.row + 2); // SUD-OUEST 2
        return diagonales;
    }
    /**
     * Méthode permettant de stocker les positions des diagonales autour de notre
     * position 
     * 
     * @param p, la Position
     * @return un tableau de Position
     */
    public static Position[] diagonalesDecroissantes(Position p) {
        Position[] diagonales = new Position[Game.nbToWin - 1];
        diagonales[0] = new Position(p.col - 1, p.row - 1); // NORD-OUEST 1
        diagonales[1] = new Position(p.col - 2, p.row - 2); // NORD-OUEST 2
        diagonales[2] = new Position(p.col + 1, p.row + 1); // SUD-EST 1
        diagonales[3] = new Position(p.col + 2, p.row + 2); // SUD-EST 2
        return diagonales;
    }
    /**
     * Méthode permettant de stocker les positions adjacentes autour de notre
     * position 
     * 
     * @param p, la Position
     * @return un tableau de Position
     */
    public static Position[] PositionAdj(Position p) {
        Position[] adj = new Position[8];
        int pos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int u = -1; u <= 1; u++) {
                if (u != 0 || i != 0) {
                    adj[pos] = new Position(p.col + u, p.row + i);
                    pos++;
                }
            }
        }

        return adj;
    }
}
