/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.classes;

import java.io.IOException;
import java.sql.SQLException;
import org.daw1.anxobastosrey.wordle.enu.Idioma;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class MotorTest implements IMotorIdioma{

    @Override
    public boolean añadirPalabra(String s) throws SQLException, IOException {
        return true;
    }

    @Override
    public boolean borrarPalabra(String s) throws SQLException, IOException {
        return true;
    }

    @Override
    public String generarPalabra() throws SQLException, IOException {
        return "CICLO";
    }

    @Override
    public Idioma getIdioma() {
        return Idioma.ES;
    }
    
}
