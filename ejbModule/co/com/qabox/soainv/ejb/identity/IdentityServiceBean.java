package co.com.qabox.soainv.ejb.identity;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.com.qabox.soainv.exception.IntegrationException;
import co.com.qabox.soainv.to.identity.IdentityDTO;
import co.com.qabox.soainv.to.identity.MenuDTO;
import co.com.qabox.soainv.to.identity.PermissionDTO;
import co.com.qabox.soainv.to.identity.RoleDTO;

/**
 * Session Bean implementation class IdentityServiceBean
 */
@Stateless
@LocalBean
public class IdentityServiceBean implements IdentityServiceLocal {

    /**
     * Default constructor. 
     */
    public IdentityServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public IdentityDTO checkUser(IdentityDTO identity)
			throws IntegrationException {
		
		System.out.println(identity);
		
		if ( IdentityDTO.basicValidation(identity) ){
			
			System.out.println("Pasamos la validacion basica");
			if ( identity.getUser().equalsIgnoreCase("pmbtgun@gmail.com")){
				System.out.println("El usauruio es " + identity.getUser());
				identity.setId(Long.valueOf(1));
				identity.setFirtName("Pedro");
				identity.setLastName("Buitrago");
				identity.setEmail("pmbtgun@gmail.com");
				
				RoleDTO rol = identity.getRole();
				rol.setId(Long.valueOf(1));
				rol.setName("Principal");
				
				PermissionDTO perms = new PermissionDTO();
				perms.setName("FULL ACCESS");
				byte[] crud = {0,0,0,0};
				perms.setCRUD(crud);
				perms.setId(Long.valueOf(1));
				perms.setBusinessObject("objeto 1");
				
				
				rol.setPermissions(new PermissionDTO[]{perms});
				identity.setRole(rol);
				
				
				return identity;
			}
		}
		System.out.println("Se retorna null");
		return null;
		
	}

	@Override
	public Collection<MenuDTO> getMenu(String user) throws IntegrationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logout(IdentityDTO identity) throws IntegrationException {
		// TODO Auto-generated method stub
		return false;
	}

}
