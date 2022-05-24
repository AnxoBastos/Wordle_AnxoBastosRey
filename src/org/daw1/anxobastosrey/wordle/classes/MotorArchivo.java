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
import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class MotorArchivo implements IMotorIdioma{
    
    
    protected static final File RUTA_DEFAULT = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_DEFAULT.txt");
    protected static final File RUTA_DEFAULT_ES = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_DEFAULT_ES.txt");
    protected static final File RUTA_FR = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_FR.txt");
    protected static final File RUTA_EN = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_EN.txt");
    protected static final File RUTA_PT = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_PT.txt");
    protected static final File RUTA_GL = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_GL.txt");
    protected static final File RUTA_IT = new File(Paths.get(".") + File.separator + "data" + File.separator + "PALABRAS_IT.txt");
    

    private File fichero;
    private Idioma idioma;
    
    public MotorArchivo(Idioma idioma){
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
    }
    
    //checkpalabra a setprecreado si añades palabra se añade y borrar igual
    //llenar string y write
    //tema color main
    
    
    @Override
    public Idioma getIdioma() {
        return idioma;
    }

    @Override
    public boolean añadirPalabra(String s) throws IOException{
        if((this.fichero.exists() && this.fichero.canWrite())){
            try(Writer wr = new BufferedWriter(new FileWriter(this.fichero, true))){
                wr.append("\n").append(s.toUpperCase());
                return true;
            }
        }
        else{
            return false;
        }    
    }

    @Override
    public boolean borrarPalabra(String s) throws IOException{
//        if((this.fichero.exists() && this.fichero.canWrite())){
//            try(Writer wr = new BufferedWriter(new FileWriter(this.fichero));
//                BufferedReader rd = new BufferedReader(new FileReader(this.fichero))){
//                StringBuilder sb = new StringBuilder();
//                String linea = rd.readLine();
//                while(linea != null){
//                    if(!linea.equals(s.toUpperCase())){
//                        sb.append(linea).append("\n");
//                    }
//                    linea = rd.readLine();
//                }
//                wr.write(sb.toString());
//                return true;
//            }
//        }
//        else{
//            return false;
//        }
        Set<String> p = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(this.fichero));
                Writer wr = new BufferedWriter(new FileWriter(RUTA_DEFAULT, true));
                Writer wrFichero = new BufferedWriter(new FileWriter(this.fichero, true))){
                String linea = br.readLine();
                while(linea != null){
                    if(!linea.equals(s.toUpperCase())){
                        p.add(linea);
                    }
                    linea = br.readLine();
                }
                for(String sa : p){
                    wr.append(sa).append("\n");
                }
                return true;
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
}
