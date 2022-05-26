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
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.daw1.anxobastosrey.wordle.enu.Idioma;
import org.daw1.anxobastosrey.wordle.gui.MainGUIWordle;
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class MotorArchivo implements IMotorIdioma, java.io.Serializable{

    private static final File CARPETA = new File(Paths.get(".") + File.separator + "data");
    
    private final File fichero;
    private final Idioma idioma;
    private final Set<String> palabras = new HashSet<>();;
    
    public MotorArchivo(Idioma idioma) throws IOException{
        this.idioma = idioma;
        if(this.idioma == Idioma.EN){
            this.fichero = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_EN.txt");
        }
        else if(this.idioma == Idioma.PT){
            this.fichero = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_PT.txt");
        }
        else if(idioma == Idioma.ES){
            this.fichero = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_ES.txt");
        }
        else if(idioma == Idioma.GL){
            this.fichero = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_GL.txt");
        }
        else if(idioma == Idioma.FR){
            this.fichero = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_FR.txt");
        }
        else{
            this.fichero = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_IT.txt");
        }
        cargarPalabras();
    }
    
    @Override
    public Idioma getIdioma() {
        return idioma;
    }
    
    @Override
    public boolean existePalabra(String s){
        s = s.toUpperCase();
        if(this.palabras.contains(s)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean añadirPalabra(String s) throws IOException{
        s = s.toUpperCase();
        if(this.fichero.exists() && this.fichero.canWrite() && !existePalabra(s)){
            try(Writer wr = new BufferedWriter(new FileWriter(this.fichero, true))){
                wr.append(s).append("\n");
                this.palabras.add(s);
                return true;
            }
        }
        else{
            return false;
        }    
    }

    @Override
    public boolean borrarPalabra(String s) throws IOException{
        s = s.toUpperCase();
        if(this.fichero.exists() && this.fichero.canWrite() && existePalabra(s)){
            try(Writer wr = new BufferedWriter(new FileWriter(this.fichero))){
                this.palabras.remove(s);
                for (String palabra : palabras) {
                    wr.append(palabra).append("\n");
                }
                return true;
            }
        }
        else{
            return false;
        }
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
                int random = new Random().nextInt(palabras.size());
                String palabraDelDia = palabras.get(random);
                return palabraDelDia;
            }
        }
        else{
            return null;
        }
    }
    
    private void cargarPalabras() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(this.fichero))){
            String linea = br.readLine();
            while(linea != null){
                this.palabras.add(linea);
                linea = br.readLine();
            }
        }
    }
}
