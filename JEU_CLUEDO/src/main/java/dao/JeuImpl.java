package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import métier.Utilisateur;

public class JeuImpl implements IJeuDao{

	@Override
	public void ajouterUtilisateur(Utilisateur u) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Utilisateur> consulterTous() {
		
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Utilisateur a");
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}

	@Override
	public void supprimerUtilisateur(int id) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Utilisateur u = em.find(Utilisateur.class, id);
		em.remove(u);
		em.getTransaction().commit();
		
	}

	@Override
	public Utilisateur consulterParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur consulterParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Utilisateur chercherUtilisateur(String userName) {
		
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select u from Utilisateur u where u.userName = :x");
		q.setParameter("x", userName);
		ArrayList<Utilisateur> u = (ArrayList<Utilisateur>) q.getResultList();
		return u.get(0);
	}

}
