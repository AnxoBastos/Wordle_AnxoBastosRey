/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.interfaces;

import org.daw1.anxobastosrey.wordle.classes.Palabra;

/**
 *
 * @author AnxoN
 */
public interface IMotorIdioma {
    
    public boolean añadirPalabra(String s);
    public boolean borrarPalabra(String s);
    public Palabra generarPalabra();
    
}
