/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author fers15
 */
@Named(value = "ajax3")
@RequestScoped
public class Ajax3 {
    
    @EJB
    private PaisesFacade paisesFacade;
    
    private String mensaje;
    int nuevo;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNuevo() {
        return nuevo;
    }

    public void setNuevo(int nuevo) {
        this.nuevo = nuevo;
    }
    
    /**
     * Creates a new instance of Ajax3
     */
    public Ajax3() {
    }
    
    //Esta clase atrapa los eventos del ajax
    public void cambiarStatusPais(AjaxBehaviorEvent event){
    
        if(paisesFacade.Cambiar_status_pais(nuevo,1).equals("OK"))
            mensaje = "Status actualizado";
        else
            mensaje = "Error al actualizar";
    }
    
}
