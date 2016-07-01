package fr.doranco.wineo.middleware.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
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
	
	public boolean ping() {
		
		final String requeteSQL = "SELECT 1";
		
		final Query requete = em.createNamedQuery(requeteSQL);
		
		return requete.getSingleResult() != null;
	}
	
	public List<Bouteille> obtenirParAnnee(Integer annee) {
		
		// J'écris ma requête.
		final String requeteSQL = "SELECT * FROM T_BOUTEILLE WHERE BOU_ANNEE = " + annee; 
		
		// Je crée la représentation java de ma requête
		final Query requete = em.createNativeQuery(requeteSQL);
		
		/*
		 * J'exécute ma requête
		 * Elle est envoyée à la BdD
		 * La BdD répond
		 * Le résultat m'est fourni sous la forme d'une liste de "truc"
		 * Je cast la liste de "truc" en une liste de bouteilles.
		 */
		return (List<Bouteille>) requete.getResultList();
	}
	
	public List<Bouteille> obtenirParDesignation(String designation) {
		
		final String requeteJPQL = "SELECT b FROM Bouteille b WHERE b.designation = " + designation;
		
		final TypedQuery<Bouteille> requeteType = em.createQuery(requeteJPQL, Bouteille.class);
		
		return requeteType.getResultList();
	}
	
	public List<Bouteille> obtenirParContenance(Integer contenance) {
		
		// J'obtiens un builder.
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		
		// Je crée une requête Criteria.
		final CriteriaQuery<Bouteille> requeteCriteria = cb.createQuery(Bouteille.class);
		// Je choisi la clause FROM de ma requête.
		final Root<Bouteille> root = requeteCriteria.from(Bouteille.class);
		// Je choisi la clause WHERE de ma requête.
		requeteCriteria.where(cb.equal(root.get("contenance"), contenance));
		
		// Je crée la représentation de la requête Critéria
		TypedQuery<Bouteille> requeteType = em.createQuery(requeteCriteria);
		
		return requeteType.getResultList();
	}
	
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
