/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import org.daw1.anxobastosrey.wordle.enu.Idioma;

/**
 *
 * @author AnxoN
 */
public interface IMotorIdioma{
    
    public boolean existePalabra(String s) throws SQLException;
    public boolean añadirPalabra(String s) throws SQLException, IOException;
    public boolean borrarPalabra(String s) throws SQLException, IOException;
    public String generarPalabra() throws SQLException, IOException;
    public Idioma getIdioma();
    
}
