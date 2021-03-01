/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelo.Users;

/**
 *
 * @author fers15
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {
    
    @EJB
    private UsersFacade usufacade;
    private HttpServletRequest httpservlet;
    
    private String username;
    private String password;
    private Users usuarioautenticado;

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users getUsuarioautenticado() {
        return usuarioautenticado;
    }

    public void setUsuarioautenticado(Users usuarioautenticado) {
        this.usuarioautenticado = usuarioautenticado;
    }

    
    
    /**
     * Creates a new instance of login
     */
    public login() {
        //Al servlet lo inicializamos para atrapar lo que tenemos en nuestra sesion 
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
    }
    
    public void Acceso() throws IOException{
        
        //Atrapamos la variable servlet
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
        //Al usuario Facade mandamos los atributos de username y pws
        usuarioautenticado = usufacade.Buscar(username,password);
        
        //En este if es donde crearemos la sesion
        if(usuarioautenticado!=null){
            //Atrapamos los datos para la sesion que queramos
            httpservlet.getSession().setAttribute("username", usuarioautenticado.getUsername());
            httpservlet.getSession().setAttribute("nombre_completo", usuarioautenticado.getNombre()+" " +usuarioautenticado.getApPat()+" " +usuarioautenticado.getApMat());
            httpservlet.getSession().setAttribute("nivel_usuario", usuarioautenticado.getIdTiposUsuarios().getNivel());
            //Esta variable de sesion es de tipo objeto, posteriormente tendremos que hacer un casteo
            httpservlet.getSession().setAttribute("usuario", usuarioautenticado);
            
            //Para identificar los tipos de usuarios y proteger las vistas
            //Donde copararemos el nivel de usuario 
            switch(usuarioautenticado.getIdTiposUsuarios().getNivel()){
                case 1:
                    //Con FacesContext el hacemos una redireccion
                    FacesContext.getCurrentInstance().getExternalContext().redirect("administrador.xhtml");
                break;
                case 2:
                    //Con FacesContext el hacemos una redireccion
                    FacesContext.getCurrentInstance().getExternalContext().redirect("vendedor.xhtml");
                break;
                default:
                    //Con FacesContext el hacemos una redireccion
                    FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
                break;
            }
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o password incorrectos",null));
        }
    }
    
    public void cerrarSesion(){
        try{
            //Destruimos todas las variables de sesion de nuestro servlet
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            //Despues de destruir hacemos un redirect a la vista que queramos
            FacesContext.getCurrentInstance().getExternalContext().redirect("/pasteleriaEcommerce2/faces/login.xhtml");
            
        }catch(Exception e){
            
        }
    } 
    
    public void verificarSesionyNivel(int nivel) throws IOException{
       //Al servlet lo inicializamos para atrapar lo que tenemos en nuestra sesion 
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
        
        //Aqui estamos haciendo el casteo de variable de sesion
        Users usu = (Users) httpservlet.getSession().getAttribute("usuario");
        
        //En este if verificamos que la sesion  esta iniciada
        if(usu !=null){
            //Aquii empzamos a proteger nuestras vistas
            if(usu.getIdTiposUsuarios().getNivel() !=nivel){
                FacesContext.getCurrentInstance().getExternalContext().redirect("sinPrivilegios.xhtml");
            }
        }else{
            //Destruimos todas las variables de sesion de nuestro servlet
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            //Despues de destruir hacemos un redirect a la vista que queramos
            FacesContext.getCurrentInstance().getExternalContext().redirect("/pasteleriaEcommerce2/faces/login.xhtml");
        }
    }
    
}
