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
import modelo.Users;
import org.apache.commons.codec.digest.DigestUtils;


/**
 *
 * @author fers15
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public List<Users> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Users.usersActivos",Users.class);
        List<Users> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Users> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Users.usersEliminados",Users.class);
        List<Users> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
     public Users Buscar(String usu, String pas){
        String pass_encrip = DigestUtils.sha1Hex(pas);
        Query consulta = em.createNamedQuery("Users.buscar",Users.class)
                .setParameter("username",usu)
                .setParameter("password", pass_encrip);
        List<Users> lista = consulta.getResultList();
        if(!lista.isEmpty()){
            return lista.get(0);
        }
        return null;
    }
     
     public String consultarUsername(String nuevo){
        Query consulta = em.createNamedQuery("Users.comprobar",Users.class)
                .setParameter("username_nuevo", nuevo);
        
        List<Users> lista = consulta.getResultList();
        if(!lista.isEmpty()){
            return "OK";
        }else{
            return "VACIO";
        }
    }
    
}
