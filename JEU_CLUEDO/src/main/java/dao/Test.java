package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import métier.Utilisateur;

public class Test {
	
	public static void main(String[] args) {
		//EntityManagerFactory emf= Persistence.createEntityManagerFactory("jeu");
		
		JeuImpl jeu = new JeuImpl();
		jeu.ajouterUtilisateur(new Utilisateur("Soufiane1","soufiane11","souf1@gmail.com","",100));
		jeu.ajouterUtilisateur(new Utilisateur("Med","med","M99@gmail.com","",50));
		jeu.ajouterUtilisateur(new Utilisateur("Soufiane22","soufiane222","souf.99@gmail.com","",1000));
		jeu.ajouterUtilisateur(new Utilisateur("mohammed","medo","md12@gmail.com","",0));
		jeu.ajouterUtilisateur(new Utilisateur("Soufiane33","soufiane333","souf.333@gmail.com","",190));
		/*System.out.println(	jeu.consulterTous());
		jeu.supprimerUtilisateur(2);*/
		//jeu.ajouterUtilisateur(new Utilisateur("Soufiane1","soufiane11","souf1@gmail.com","",100));
		//System.out.println(jeu.chercherUtilisateur("Med"));
	}

}
