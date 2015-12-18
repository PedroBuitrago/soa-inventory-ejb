package co.com.qabox.soainv.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TechnicalServiceBean
 */
@Stateless(mappedName = "TechnicalServiceBean")
@LocalBean
public class TechnicalServiceBean implements TechnicalServiceRemote, TechnicalServiceLocal {
	
    /**
     * Default constructor. 
     */
    public TechnicalServiceBean() {
        // TODO Auto-generated constructor stub
    }

}
