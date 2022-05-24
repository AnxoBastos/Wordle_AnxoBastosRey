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
public class MotorBase implements IMotorIdioma, java.io.Serializable{

    private static final String URL = "jdbc:sqlite:data/dbwordle.db";
    
    private Idioma idioma;

    public MotorBase(Idioma idioma){
        this.idioma = idioma;
    }

    public Idioma getIdioma() {
        return idioma;
    }
    //SELECT COUNT(*) AS TOTAL WHERE lang = ? AND palabra = ? rs.next()
    @Override
    public boolean existePalabra(String s) throws SQLException{
        s = s.toUpperCase();
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) AS TOTAL WHERE lang = ? AND palabra = ?")){
            ps.setString(1, this.idioma.toString());
            ps.setString(2, s);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.getInt("TOTAL") > 0) {
                    return true;
                }
                else{
                    return false;
                }
            }
            
        }
    }
    
    @Override
    public boolean añadirPalabra(String s) throws SQLException {
        s = s.toUpperCase();
        if(existePalabra(s)){
            try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement ps = conn.prepareStatement("INSERT INTO palabras(palabra, lang) VALUES (?,?)")){
                ps.setString(1, s.toUpperCase());
                ps.setString(2, this.idioma.toString());
                int cont = ps.executeUpdate();
                return cont > 0;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public boolean borrarPalabra(String s) throws SQLException {
        s = s.toUpperCase();
        if (!existePalabra(s)) {
            try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement ps = conn.prepareStatement("DELETE FROM palabras WHERE (palabra = ? AND lang = ?)")){
                ps.setString(1, s);
                ps.setString(2, this.idioma.toString());
                int cont = ps.executeUpdate();
                return cont > 0;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public String generarPalabra() throws SQLException {
        try(Connection conn = DriverManager.getConnection(this.URL);
            PreparedStatement ps = conn.prepareStatement("SELECT palabra FROM palabras WHERE lang = ? LIMIT ?, 1")){
            ps.setString(1, this.idioma.toString());
            ps.setInt(2, (int)Math.random() * 3);
            try(ResultSet rs = ps.executeQuery()){
                String palabra = rs.getString("palabra");
                return palabra;
            }
        }
    }
    
    private int tamanhoBase() throws SQLException{
        int resultado = 0;
        try(Connection conn = DriverManager.getConnection(this.URL);
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) AS TOTAL WHERE lang = ?")){
            ps.setString(1, this.idioma.toString());
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    resultado = rs.getInt("TOTAL");
                }
            }
        }
        return resultado;
    }

}    
