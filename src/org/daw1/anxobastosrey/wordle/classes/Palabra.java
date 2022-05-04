/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.classes;

import java.util.Objects;

/**
 *
 * @author AnxoN
 */
public class Palabra {
    
    private String palabra;
    private Character posUno;
    private Character posDos;
    private Character posTres;
    private Character posCuatro;
    private Character posCinco;
    
    public Palabra(String palabra){
        palabra = palabra.toUpperCase();
        checkPalabra(palabra);
        this.palabra = palabra;
        this.posUno = palabra.charAt(0);
        this.posDos = palabra.charAt(1);
        this.posTres = palabra.charAt(2);
        this.posCuatro = palabra.charAt(3);
        this.posCinco = palabra.charAt(4);
    }
    
    private static void checkPalabra(String s){
        if(s == null || !s.matches("[A-Z]{5}")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.palabra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palabra other = (Palabra) obj;
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return true;
    }
       
}
