package com.iut.as.main;

import java.util.List;

import com.iut.as.enumerations.EPersistance;
import com.iut.as.factory.dao.DaoFactory;
import com.iut.as.interfaces.IDaoClient;
import com.iut.as.interfaces.IDaoCompte;
import com.iut.as.modele.Client;
import com.iut.as.modele.Compte;

public class StartPoint {

	public static void main(String[] args) {
		try {
			// Connection à la base MySQL :
			DaoFactory daoF = DaoFactory.getDaoFactory(EPersistance.MYSQL);
			// Connection à la table 'compte' :
			IDaoCompte dao = daoF.getDaoCompte();
			// Connection à la table 'client' :
			IDaoClient daoClient = daoF.getDaoClient(); // 1 -> Appel DAO
			System.out.println("===============================");
			System.out.println("Voici la liste des comptes : ");
			List<Compte> comptes = dao.getComptes(); 
			for (Compte compte : comptes) {
				System.out.println(compte.toString());
			}
			System.out.println("===============================");
			System.out.println("Voici la liste des clients : ");
			List<Client> clients = daoClient.getListClient();
			// Je vais réaliser le lien compte - client pour la démonstration :
			for (Client client : clients) {
				System.out.println(client.toString());
				//getComptesByClient(dao, client);
			}
		} catch (Exception e) {
			System.out.println("Connection impossible " + e.getMessage());
		}

	}

	private static void getComptesByClient(IDaoCompte dao, Client client) {
		// Récupération des comptes du client : --> 1 Appel Dao par client :
		List<Compte> comptesClient = dao.getComptesByClient(client.getNumeroClient());
		for (Compte compte : comptesClient) {
			client.addCompte(compte);
			System.out.println(compte.toString());
		}
	}
}
