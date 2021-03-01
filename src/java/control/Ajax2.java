/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author fers15
 */
@Named(value = "ajax2")
@RequestScoped
public class Ajax2 {
    
    private String nombre;
    private String nombre2;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    
    
    /**
     * Creates a new instance of Ajax2
     */
    public Ajax2() {
    }
    
}
