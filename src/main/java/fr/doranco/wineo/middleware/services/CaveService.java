package fr.doranco.wineo.middleware.services;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.doranco.wineo.middleware.dao.BouteilleDao;
import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInvalideException;
import fr.doranco.wineo.middleware.objetmetier.cave.Cave;
import fr.doranco.wineo.middleware.objetmetier.cave.CaveInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.cave.CaveInvalideException;
import fr.doranco.wineo.middleware.objetmetier.cave.PlaceInsuffisanteException;

/**
 * Un service de gestion des caves.
 * 
 * @author Snekkja JFDC
 */
@Stateless
public class CaveService implements ICaveService {
	
	@EJB
	private BouteilleDao bouteilleDao;
	
	@EJB
	private IBouteilleService bouteilleService;

	@Override
	public void ajouterBouteille(final Bouteille bouteille, final Cave cave)
			throws PlaceInsuffisanteException, BouteilleInexistanteException,
			CaveInexistanteException, BouteilleInvalideException, CaveInvalideException {
		
		// Nous vérifions que la bouteille existe.
		if (bouteille == null)
			throw new BouteilleInexistanteException();
		
		// Nous vérifions que la cave existe.
		if (cave == null)
			throw new CaveInexistanteException();
			
		// Nous vérifions que la bouteille est valide.
		if (!validerBouteille(bouteille))
			throw new BouteilleInvalideException();
			
		// Nous vérifions que la cave est valide.
		if (!validerCave(cave))
			throw new CaveInvalideException();
		
		// Nous persistons maintenant la bouteille fournie.
		bouteilleDao.persister(bouteille);
		
	}

	@Override
	public void retirerBouteille(Bouteille bouteille) {
		
	}

	@Override
	public Bouteille obtenirBouteille(String reference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bouteille> obtenirBouteille(Predicate<Bouteille> condition, Cave cave) {
		
		return null;
	}

	@Override
	public Integer obtenirCapaciteRestante(Cave cave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean verifierCapaciteRestante(Integer nombreBouteilleAjouter, Cave cave) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Valider la cohérence d'une bouteille.
	 * 
	 * @param candidat Une bouteille candidate.
	 * @return Vrai si la bouteille est cohérente et valide.
	 */
	private boolean validerBouteille(final Bouteille candidat) {
		// Algorithme de validation de bouteille
		// new Random().nextBoolean();
		return true; 
	}
	
	/**
	 * Valider la cohérence d'une cave.
	 * 
	 * @param candidat Une cave candidate.
	 * @return Vrai si la cave est cohérente et valide.
	 */
	private boolean validerCave(final Cave candidat) {
		// Algorithme de validation de cave
		return true;
	}

	@Override
	public void ajouterBouteilles(Collection<Bouteille> bouteilles, Cave cave) throws PlaceInsuffisanteException,
			BouteilleInexistanteException, CaveInexistanteException, BouteilleInvalideException, CaveInvalideException {
		
	}

}
