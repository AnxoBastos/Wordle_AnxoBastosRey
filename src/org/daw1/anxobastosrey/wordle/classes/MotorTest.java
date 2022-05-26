/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.classes;

import org.daw1.anxobastosrey.wordle.enu.Idioma;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class MotorTest implements IMotorIdioma{

    @Override
    public Idioma getIdioma() {
        return Idioma.ES;
    }
    
    @Override
    public boolean existePalabra(String s){
        return true;
    }
    
    @Override
    public boolean añadirPalabra(String s){
        return true;
    }

    @Override
    public boolean borrarPalabra(String s){
        return true;
    }

    @Override
    public String generarPalabra(){
        return "CICLO";
    }
    
    @Override
    public String mostrarPalabras(){
        return "CICLO";
    }
}
