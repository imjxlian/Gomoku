/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author jforme/tduthil
 */
public class InvalidSizeException extends Exception {

    /**
     * Soulève une exception si la largeur/hauteur est inférieur à 5 ou supérieur à 6
     * @param hauteur, la hauteur du plateau
     * @param largeur, la largeur du plateau
     */
    public InvalidSizeException(int hauteur, int largeur) {
        System.out.println("La hauteur et la largeur du plateau doivent être compris entre 5 et 26 inclus. Hauteur: " + hauteur + " Largeur: " + largeur);
    }
    
}
