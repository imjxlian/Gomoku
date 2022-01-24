/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Jeu.Board;
import Jeu.Position;

/**
 *
 * @author tduthil/jforme
 */
public interface Player  {
    Position choice(Board b);
    public String getUsername();
    public void initUsername();
}
