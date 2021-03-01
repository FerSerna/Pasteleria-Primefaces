package control;

import modelo.Fotosproductos;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.model.UploadedFile;

@Named("fotosproductosController")
@SessionScoped
public class FotosproductosController implements Serializable {

    @EJB
    private control.FotosproductosFacade ejbFacade;
    private List<Fotosproductos> items = null;
    private List<Fotosproductos> itemsEliminados = null;
    private Fotosproductos selected;
    
    //AÑADIENDO COLUMNA FOTO
    private UploadedFile foto;
    private String aux;

    public FotosproductosController() {
    }    

    // consultarEliminados() -> sustituye a findAll() que venia por defecto
    //Y se crea en el Facade
    public List<Fotosproductos> getItemsEliminados() {
        if (itemsEliminados == null) {
            //items = getFacade().findAll();
            itemsEliminados = getFacade().consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Fotosproductos> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    
    
    public Fotosproductos getSelected() {
        return selected;
    }

    public void setSelected(Fotosproductos selected) {
        this.selected = selected;
    }
    
    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FotosproductosFacade getFacade() {
        return ejbFacade;
    }

    public Fotosproductos prepareCreate() {
        selected = new Fotosproductos();
        initializeEmbeddableKey();
        return selected;
    }
    
    
    //Para subir y guardar en archivo en carpeta, pero la ruta en la DB
     public void NuevoDocumento(){
         
        System.out.println("MIME TYPE: " + getFoto().getContentType());
        //System.out.println("TAMAÑO: " + getFoto().getSize());
        System.out.println("EXTENSION PNG: " + getFoto().getFileName().endsWith(".png"));
        System.out.println("EXTENSION JPG: " + getFoto().getFileName().endsWith(".jpg"));
        System.out.println("EXTENSION GIF: " + getFoto().getFileName().endsWith(".gif"));
        System.out.println("EXTENSION ZIP: " + getFoto().getFileName().endsWith(".zip"));
        System.out.println("EXTENSION PDF: " + getFoto().getFileName().endsWith(".pdf"));
        System.out.println("EXTENSION ODS: " + getFoto().getFileName().endsWith(".ods"));
        System.out.println("EXTENSION CSV: " + getFoto().getFileName().endsWith(".csv"));
        
        if (getFoto().getFileName().endsWith(".png") 
                || getFoto().getFileName().endsWith(".jpg")
                || getFoto().getFileName().endsWith(".gif")
                || getFoto().getFileName().endsWith(".zip")
                || getFoto().getFileName().endsWith(".pdf")
                || getFoto().getFileName().endsWith(".ods")
                || getFoto().getFileName().endsWith(".csv")){
            if (SubirArchivo()){
                create();
                aux ="";
                
            }
            
        }else{
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"El archivo No es una imagen",null));
       
            FacesMessage mensaje = new FacesMessage("El archivo NO es una imagen o un archivo valido,Favor de verificar");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            
            selected= null;
        }
        
        
        
//         if (SubirArchivo()) {
//             create();
//             aux = "";
//         }
    }
   
    
    public Boolean SubirArchivo(){
        try{
            aux = "resources/fotosproductos";
            
            System.out.println("RUTA: "+ aux);
            File archivo = new File(JsfUtil.getPath() + aux);
            if(!archivo.exists()){
                archivo.mkdirs();
            }
            copiar_archivo(getFoto().getFileName(),getFoto().getInputstream());
            return true;
            
        } catch(Exception e){
            return false;
        }
    }
    
    public void copiar_archivo(String nombre_archivo, InputStream in){
        
        try{
            aux=aux+"/" + nombre_archivo;
            System.out.println("Se va a guardar");
            System.out.println("Ruta ok: "+aux);
            System.out.println("Ruta real: "+JsfUtil.getPath() + aux);
            OutputStream out = new FileOutputStream(new File(JsfUtil.getPath()+ aux));
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = in.read(bytes)) !=-1){
                out.write(bytes,0,read);
            }
            System.out.println("Ha sido guardado");
            aux = aux.substring(9);
            System.out.println("Ruta en la base: "+ aux);
            in.close();
            out.flush();
            out.close();
        } catch(Exception e){
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("Error al subir archivo"));
             
        }
        
    }

    public void create() {
        //Hacer el valor por defecto del status
        selected.setStatus(1);
        selected.setRuta(aux);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosUpdated"));
    }

    public void destroy() {
        //BORRADO LOGICO: cambio para que en lugar de eliminar solo actualice el status a baja (0)
        selected.setStatus(0);
        //persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosDeleted"));
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            //Llamamos a estos itemsEliminados para que los vuelva a referescar
            itemsEliminados = null;
        }
    }
    
    public void restaurar() {
        selected.setStatus(1);
        //persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosDeleted"));
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;
            //Llamamos a estos items para que los vuelva a referescar
            items = null;// Invalidate list of items to trigger re-query.
        }
    }

    // consultarActivos() -> sustituye a findAll() que venia por defecto
    //Y se crea en Facade
    public List<Fotosproductos> getItems() {
        if (items == null) {
            //items = getFacade().findAll();
            items = getFacade().consultarActivos();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    

    public Fotosproductos getFotosproductos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Fotosproductos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Fotosproductos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Fotosproductos.class)
    public static class FotosproductosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FotosproductosController controller = (FotosproductosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fotosproductosController");
            return controller.getFotosproductos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Fotosproductos) {
                Fotosproductos o = (Fotosproductos) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Fotosproductos.class.getName()});
                return null;
            }
        }

    }
   

}
