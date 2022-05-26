/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle;

import java.io.IOException;
import java.sql.SQLException;
import org.daw1.anxobastosrey.wordle.classes.MotorArchivo;
import org.daw1.anxobastosrey.wordle.classes.MotorBase;
import org.daw1.anxobastosrey.wordle.enu.Idioma;


/**
 *
 * @author AnxoN
 */
public class WordleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        MotorArchivo motor = new MotorArchivo(Idioma.ES);
        System.out.println(motor.mostrarPalabras());
    }
}
