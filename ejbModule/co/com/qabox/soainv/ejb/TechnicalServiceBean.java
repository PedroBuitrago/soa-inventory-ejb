package co.com.qabox.soainv.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import co.com.qabox.soainv.to.TechnicalServiceTO;

/**
 * Session Bean implementation class TechnicalServiceBean
 */
@Stateful
@Local(TechnicalServiceLocal.class)
@Remote(TechnicalServiceRemote.class)
@RequestScoped
public class TechnicalServiceBean implements TechnicalServiceLocal, TechnicalServiceRemote {
	
    /**
     * Default constructor. 
     */
    public TechnicalServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean saveInfo(TechnicalServiceTO to){
    	System.out.println("############################");
    	System.out.println(to.getName());
    	System.out.println("############################");
    	return true;
    }
    

}
