/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.cataloglo.servicio.RequerimientoFacadeLocal;
import ec.com.catalogo.modelo.Funcionario;
import ec.com.catalogo.modelo.Requerimiento;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@ViewScoped
public class PerfilController implements Serializable {
    
    @EJB
    private RequerimientoFacadeLocal reqEJB;
    private List<Requerimiento> requerimientos;

    public List<Requerimiento> getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(List<Requerimiento> requerimientos) {
        this.requerimientos = requerimientos;
    }

    
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Funcionario usr = (Funcionario) context.getExternalContext().getSessionMap().get("usuario");
        requerimientos = reqEJB.findByUsr(usr.getIdFuncionario());
    }
    
}
