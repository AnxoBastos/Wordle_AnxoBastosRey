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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class MotorArchivo implements IMotorIdioma{
    
    private File fichero;
    
    public MotorArchivo(File fichero){
        this.fichero = fichero;
    }

    @Override
    public boolean añadirPalabra(String s) throws IOException{
        if((this.fichero.exists() && this.fichero.canWrite())){
            try(Writer wr = new BufferedWriter(new FileWriter(this.fichero))){
                wr.write(s.toUpperCase());
                return true;
            }
        }
        else{
            return false;
        }    
    }

    @Override
    public boolean borrarPalabra(String s) throws IOException{
        if((this.fichero.exists() && this.fichero.canWrite())){
            try(Writer wr = new BufferedWriter(new FileWriter(this.fichero));
                BufferedReader rd = new BufferedReader(new FileReader(this.fichero))){
                String palabra = rd.readLine();
                while(palabra != null){
                    if(palabra.equals(s.toUpperCase())){
                        wr.flush();
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String generarPalabra() throws IOException{
        if(this.fichero.exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(this.fichero))){
                List <String> palabras = new ArrayList<>();
                String palabra = br.readLine();
                while(palabra != null){
                    palabras.add(palabra);
                    palabra = br.readLine();
                }
                int random = new Random().nextInt(palabras.size() - 1);
                String palabraDelDia = palabras.get(random);
                return palabraDelDia;
            }
        }
        else{
            return null;
        }
    }
}
