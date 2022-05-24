/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.anxobastosrey.wordle.classes;

import org.daw1.anxobastosrey.wordle.interfaces.IMotorIdioma;

/**
 *
 * @author AnxoN
 */
public class PairMotorTema implements java.io.Serializable{

    private IMotorIdioma motor;
    private Boolean tema;
    
    public PairMotorTema(IMotorIdioma motor, Boolean tema) {
        this.motor = motor;
        this.tema = tema;
    }

    public IMotorIdioma getMotor() {
        return motor;
    }

    public Boolean getTema() {
        return tema;
    }
      
}
