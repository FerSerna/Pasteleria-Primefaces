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
import modelo.Paises;

/**
 *
 * @author fers15
 */
@Stateless
public class PaisesFacade extends AbstractFacade<Paises> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisesFacade() {
        super(Paises.class);
    }
    
    public List<Paises> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Paises.paisesActivos",Paises.class);
        List<Paises> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Paises> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Paises.paisesEliminados",Paises.class);
        List<Paises> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
    public String Cambiar_status_pais(int nuevo, int idPais){
        Query consulta = em.createNamedQuery("Paises.cambia1",Paises.class)
                .setParameter("status_pais", nuevo)
                .setParameter("id_pais", idPais);
        consulta.executeUpdate();
        return "OK";
    }
    
}
