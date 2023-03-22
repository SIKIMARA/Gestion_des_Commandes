package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Information;




public class InformationDao {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager=Persistence.createEntityManagerFactory("TP2_JPA").createEntityManager();
		}
		return entityManager;
	}
	
	
	public void  AjouterInformation(Information Information) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(Information);
		getEntityManager().getTransaction().commit();
		
	}
	public void  RemoveInformation(Information Information) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(Information);
		getEntityManager().getTransaction().commit();
		
	}
	public void  ModifierInformation(Information Information) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(Information);
		getEntityManager().getTransaction().commit();
		
	}
	public Information FindInformation(int id) {
		return getEntityManager().find(Information.class, id);
	}
	
	public List<Information> findAll(){
		return getEntityManager().createQuery("select c from Information c",Information.class).getResultList();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
