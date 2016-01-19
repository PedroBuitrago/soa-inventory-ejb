package co.com.qabox.soainv.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;

import co.com.qabox.soainv.to.TechnicalServiceTO;

/**
 * Session Bean implementation class TechnicalServiceBean
 */
@Stateless
@Local(TechnicalServiceLocal.class)
@Remote(TechnicalServiceRemote.class)
@ViewScoped
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
