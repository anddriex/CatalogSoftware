/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Requerimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author carlosballadares
 */
@Stateless
public class RequerimientoFacade extends AbstractFacade<Requerimiento> implements RequerimientoFacadeLocal {

    @PersistenceContext(unitName = "catalogoSoftwarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequerimientoFacade() {
        super(Requerimiento.class);
    }
    
    @Override
    public List<Requerimiento> findByUsr(int usrId) {
        List<Requerimiento> reqs = null;
        String consulta;
        try {
            consulta = "FROM Requerimiento r WHERE r.id_Solicitante = 1?";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usrId);
            reqs = query.getResultList();
        } catch(Exception e) {
            throw e;
        }
        
        return reqs;
    }
    
}
