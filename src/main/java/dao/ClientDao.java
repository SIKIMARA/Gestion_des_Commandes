package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import model.Client;
import model.Information;

public class ClientDao {
	
	private final String JPA_UNIT_NAME= "TP2_JPA";
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager =  Persistence.createEntityManagerFactory(JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void AjouterClient(Client client) {
		getEntityManager().getTransaction().begin();
//		Information info = getEntityManager().find(Information.class, client.getInformation());
//		client.setInformation(info);
		getEntityManager().persist(client);
		getEntityManager().getTransaction().commit();
	}
	
	public void ModifierClient(Client client) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(client);
		getEntityManager().getTransaction().commit();
	}
	
	public void RemoveClient(Client client) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(client);
		getEntityManager().getTransaction().commit();
	}
	
	
	public Client findClient(int id) {
		return getEntityManager().find(Client.class, id);
	}
	
	
	public List<Client> findAll() {
		javax.persistence.Query query = getEntityManager().createQuery("select c from Client c");
		return query.getResultList();
		
	}
	
	

}
