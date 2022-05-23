package dao;


import java.util.List;

import métier.Utilisateur;

public interface IJeuDao {
	
	void ajouterUtilisateur(Utilisateur u);
	List<Utilisateur> consulterTous();
	void supprimerUtilisateur(int id);
	Utilisateur consulterParId(int id);
	Utilisateur consulterParNom(String nom);
	Utilisateur chercherUtilisateur(String userName);

}
