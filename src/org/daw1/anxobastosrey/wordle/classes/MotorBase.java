/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.classes;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.daw1.anxobastosrey.wordle.enu.Idioma;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class MotorBase implements IMotorIdioma{

    private static final String URL = "jdbc:sqlite:data/dbwordle.db";
    
    private Idioma idioma;

    public MotorBase(Idioma idioma){
        this.idioma = idioma;
    }

    public Idioma getIdioma() {
        return idioma;
    }
    
    @Override
    public boolean añadirPalabra(String s) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO palabras(palabra, lang) VALUES (?,?)")){
            ps.setString(1, s.toUpperCase());
            ps.setString(2, this.idioma.toString());
            int cont = ps.executeUpdate();
            return cont > 0;
        }
    }

    @Override
    public boolean borrarPalabra(String s) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM palabras WHERE (palabra = ? AND lang = ?)")){
            ps.setString(1, s.toUpperCase());
            ps.setString(2, this.idioma.toString());
            int cont = ps.executeUpdate();
            return cont > 0;
        }
    }

    @Override
    public String generarPalabra() throws SQLException {
        try(Connection conn = DriverManager.getConnection(this.URL);
            PreparedStatement ps = conn.prepareStatement("SELECT palabra FROM palabras WHERE lang = ? ORDER BY RANDOM() LIMIT 1")){
            ps.setString(1, this.idioma.toString());
            try(ResultSet rs = ps.executeQuery()){
                String palabra = rs.getString("palabra");
                return palabra;
            }
        }
    }
}    
