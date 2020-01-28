
package ec.com.catalogo.controlador;

import ec.com.cataloglo.servicio.RequerimientoFacadeLocal;
import ec.com.catalogo.modelo.Requerimiento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AprobarController implements Serializable {
    
    @EJB
    private RequerimientoFacadeLocal rfcEJB;
    private List<Requerimiento> notas;
    private Requerimiento requerimiento;
    
    public List<Requerimiento> getNotas() {
        return notas;
    }

    public void setNotas(List<Requerimiento> notas) {
        this.notas = notas;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }
    
    
    
    @PostConstruct
    public void init() {
        notas = rfcEJB.findAll();
    }
    
    public void aprobar(Requerimiento req) {
        this.requerimiento = req;
        try {
            this.requerimiento.setEstado("Aprobado");
            rfcEJB.edit(requerimiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Aprobacion exitosa"));
        }catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        } finally {
            
        }
    }
    
    
}
