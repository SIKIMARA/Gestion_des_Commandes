package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String lastname;

	private String name;

	//bi-directional many-to-one association to Information
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Id_information")
	private Information information;

	//bi-directional many-to-many association to Produit
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="client_produit"
		, joinColumns={
			@JoinColumn(name="Client_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Produit_id")
			}
		)
	private List<Produit> produits;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Information getInformation() {
		return this.information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}