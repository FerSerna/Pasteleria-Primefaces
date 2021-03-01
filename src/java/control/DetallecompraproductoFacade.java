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
import modelo.Detallecompraproducto;

/**
 *
 * @author fers15
 */
@Stateless
public class DetallecompraproductoFacade extends AbstractFacade<Detallecompraproducto> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallecompraproductoFacade() {
        super(Detallecompraproducto.class);
    }
    
    public List<Detallecompraproducto> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Detallecompraproducto.detalleCompraProductoActivos",Detallecompraproducto.class);
        List<Detallecompraproducto> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Detallecompraproducto> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Detallecompraproducto.detalleCompraProductoEliminados",Detallecompraproducto.class);
        List<Detallecompraproducto> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
}
