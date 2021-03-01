/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Detalleventaproducto;

/**
 *
 * @author fers15
 */
@Stateless
public class DetalleventaproductoFacade extends AbstractFacade<Detalleventaproducto> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleventaproductoFacade() {
        super(Detalleventaproducto.class);
    }
    
    public List<Detalleventaproducto> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Detalleventaproducto.detalleVentaProductoActivos",Detalleventaproducto.class);
        List<Detalleventaproducto> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Detalleventaproducto> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Detalleventaproducto.detalleVentaProductoEliminados",Detalleventaproducto.class);
        List<Detalleventaproducto> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
            
    
}
