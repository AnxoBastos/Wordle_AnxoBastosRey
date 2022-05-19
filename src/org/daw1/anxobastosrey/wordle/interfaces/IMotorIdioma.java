/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.interfaces;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author AnxoN
 */
public interface IMotorIdioma {
    
    public boolean añadirPalabra(String s)throws IOException;
    public boolean borrarPalabra(String s) throws IOException;
    public String generarPalabra() throws IOException;
    
}
