/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.LinkedList;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class MotorArchivo implements IMotorIdioma{
    
    private List<Character> palabraDelDia;
    private static final File RUTA = null;
    
    

    @Override
    public boolean añadirPalabra(String s) throws IOException{
        if((RUTA.exists() && RUTA.canWrite()) || (!RUTA.exists() && RUTA.getParentFile().canWrite())){
            try(Writer wr = new BufferedWriter(new  FileWriter(RUTA))){
                wr.write(s);
                return true;
            }
        }
        else{
            return false;
        }    
    }

    @Override
    public boolean borrarPalabra(String s) throws IOException{
        
    }

    @Override
    public String generarPalabra() throws IOException{
        if(fichero.exists()){
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(fichero))){
                String linea = br.readLine();
                while(linea != null){
                    sb.append(linea).append("\n");
                    linea = br.readLine();
                }
                return sb.toString();
            }
        }
        else{
            return null;
        }
    }
}
