package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Categorie;
import model.Categorie;




public class CategorieDao {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager=Persistence.createEntityManagerFactory("TP2_JPA").createEntityManager();
		}
		return entityManager;
	}
	
	
	public void  AjouterCategorie(Categorie Categorie) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(Categorie);
		getEntityManager().getTransaction().commit();
		
	}
	public void  RemoveCategorie(Categorie Categorie) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(Categorie);
		getEntityManager().getTransaction().commit();
		
	}
	public void  ModifierCategorie(Categorie Categorie) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(Categorie);
		getEntityManager().getTransaction().commit();
		
	}
	public Categorie FindCategorie(int id) {
		return getEntityManager().find(Categorie.class, id);
	}
	
	public List<Categorie> findAll(){
		return getEntityManager().createQuery("select c from Categorie c",Categorie.class).getResultList();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
