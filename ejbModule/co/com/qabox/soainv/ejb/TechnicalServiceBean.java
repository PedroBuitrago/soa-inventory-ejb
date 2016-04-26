package co.com.qabox.soainv.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.qabox.soainv.to.TechnicalServiceTO;

/**
 * Session Bean implementation class TechnicalServiceBean
 */
@Stateless
@Local(TechnicalServiceLocal.class)
@Remote(TechnicalServiceRemote.class)
public class TechnicalServiceBean extends AbstractDAOServices<TechnicalServiceTO> implements TechnicalServiceLocal, TechnicalServiceRemote {
	
	 @PersistenceContext(unitName = "soaInvPersisteceUnit")
	 private EntityManager em;
	
    public TechnicalServiceBean() {
       super(TechnicalServiceTO.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
