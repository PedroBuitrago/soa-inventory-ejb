package co.com.qabox.soainv.ejb;

import java.util.List;

import javax.persistence.EntityManager;

import co.com.qabox.soainv.exception.SoaInventoryException;

public abstract class AbstractDAOServices<T> implements EEServicesInterface<T>{
	
	private Class<T> entityClass;

    public AbstractDAOServices(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) throws SoaInventoryException{
        try{
        	getEntityManager().persist(entity);
        }catch(Exception e){
        	throw new SoaInventoryException("Error creando " + entity.getClass() + ". ", e);
        }
    }

    public void edit(T entity) throws SoaInventoryException{
    	try{
        	getEntityManager().merge(entity);
        }catch(Exception e){
        	throw new SoaInventoryException("Error editando " + entity.getClass() + ". ", e);
        }
    }

    public void remove(T entity) throws SoaInventoryException {
    	
    	try{
    		 getEntityManager().remove(getEntityManager().merge(entity));
        }catch(Exception e){
        	throw new SoaInventoryException("Error eliminando " + entity.getClass() + ". ", e);
        }
    	
       
    }

    public T find(Object id) throws SoaInventoryException{
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() throws SoaInventoryException{
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) throws SoaInventoryException {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() throws SoaInventoryException{
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    

}
