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
import modelo.Tiposusuario;

/**
 *
 * @author fers15
 */
@Stateless
public class TiposusuarioFacade extends AbstractFacade<Tiposusuario> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposusuarioFacade() {
        super(Tiposusuario.class);
    }
    
    public List<Tiposusuario> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Tiposusuario.tiposUsuarioActivos",Tiposusuario.class);
        List<Tiposusuario> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Tiposusuario> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Tiposusuario.tiposUsuarioEliminados",Tiposusuario.class);
        List<Tiposusuario> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
}
