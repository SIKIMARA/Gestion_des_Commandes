package main;

import dao.ClientDao;
import model.Client;

public class main {

	public static void main(String[] args) {
		ClientDao dao =new ClientDao();
		Client client =new Client();
		for(Client c :  dao.findAll()) {
			System.out.println(c.getId());
		}
	}

}
