/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.daw1.anxobastosrey.wordle.gui.MainGUIWordle;


/**
 *
 * @author AnxoN
 */
public class WordleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUIWordle().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainGUIWordle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
