package fr.doranco.wineo.middleware.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;

/**
 * Un DAO JPA de gestion des bouteilles.
 * 
 * @author Snekkja JFDC
 */
@Stateless
@Transactional
public class BouteilleDao {

	// Injecte un manageur d'entité construit
	// depuis le paramétrage de l'unité de persistence par défaut.
	@PersistenceContext
	private EntityManager em;
	
	public void persister(Bouteille bouteille) {
		
		em.persist(bouteille);
	}
	
	public Bouteille obtenir(String reference) {
		
		// Je récupère juste la référence de mon entité.
		// Bouteille bouteille = em.getReference(Bouteille.class, reference);
		// Je récupère les informations de mon entité.
		// Bouteille bouteille2 = em.find(Bouteille.class, reference);
		return em.find(Bouteille.class, reference);
	}
	
	public void retirer(String reference) {
		
		em.remove(em.getReference(Bouteille.class, reference));
	}
	
	public void modifier(Bouteille bouteille) {
		
		em.merge(bouteille);
	}
	
}
