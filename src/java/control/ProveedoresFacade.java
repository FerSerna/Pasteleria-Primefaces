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
import modelo.Proveedores;

/**
 *
 * @author fers15
 */
@Stateless
public class ProveedoresFacade extends AbstractFacade<Proveedores> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresFacade() {
        super(Proveedores.class);
    }
    
    public List<Proveedores> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Proveedores.proveedoresActivos",Proveedores.class);
        List<Proveedores> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Proveedores> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Proveedores.proveedoresEliminados",Proveedores.class);
        List<Proveedores> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
}
