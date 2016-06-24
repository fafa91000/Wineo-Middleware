package fr.doranco.wineo.middleware.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInvalideException;
import fr.doranco.wineo.middleware.objetmetier.cave.Cave;
import fr.doranco.wineo.middleware.objetmetier.cave.CaveInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.cave.CaveInvalideException;
import fr.doranco.wineo.middleware.objetmetier.cave.Entrepot;
import fr.doranco.wineo.middleware.objetmetier.cave.PlaceInsuffisanteException;

/**
 * Un service de gestion des caves.
 * 
 * @author Snekkja JFDC
 */
@Stateless
public class CaveService implements ICaveService {
	
	@EJB
	private IBouteilleService bouteilleService;

	/**
	 * L'entrepot commun des services de gestion de cave.
	 */
	private Entrepot entrepot;
	
	public CaveService() {
		super();
	}
	
	public CaveService(Entrepot entrepot) {
		super();
		this.entrepot = entrepot;
	}
	
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
		
		// Nous vérifions qu'il reste de la place.
		final Set<Cave> caves = entrepot.getCaves();
		
		// Lambdas voir :
		// https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
		final Cave caveDestinataire = caves.stream()
			.filter(c -> c.getReference().equals(cave.getReference()))
			.findFirst()
			.orElseThrow(CaveInexistanteException::new);
		
		if (caveDestinataire.getCapaciteMaximale() > caveDestinataire.getBouteilles().size())
			// Nous ajoutons la bouteille.
			caveDestinataire.getBouteilles().put(bouteille.getReference(), bouteille);
		else
			throw new PlaceInsuffisanteException("Y a pas de place !");
		
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
