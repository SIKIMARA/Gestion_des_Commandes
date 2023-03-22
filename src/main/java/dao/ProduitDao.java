package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Produit;





public class ProduitDao {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager=Persistence.createEntityManagerFactory("TP2_JPA").createEntityManager();
		}
		return entityManager;
	}
	
	
	public void  AjouterProduit(Produit Produit) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(Produit);
		getEntityManager().getTransaction().commit();
		
	}
	public void  RemoveProduit(Produit Produit) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(Produit);
		getEntityManager().getTransaction().commit();
		
	}
	public void  ModifierProduit(Produit Produit) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(Produit);
		getEntityManager().getTransaction().commit();
		
	}
	public Produit FindProduit(int id) {
		return getEntityManager().find(Produit.class, id);
	}
	
	public List<Produit> findAll(){
		return getEntityManager().createQuery("select c from Produit c",Produit.class).getResultList();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
