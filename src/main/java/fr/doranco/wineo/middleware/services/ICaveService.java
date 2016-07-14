package fr.doranco.wineo.middleware.services;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleDejaExistanteException;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInvalideException;
import fr.doranco.wineo.middleware.objetmetier.cave.Cave;
import fr.doranco.wineo.middleware.objetmetier.cave.CaveInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.cave.CaveInvalideException;
import fr.doranco.wineo.middleware.objetmetier.cave.PlaceInsuffisanteException;

public interface ICaveService {

	public void ajouterBouteille(Bouteille bouteille, Cave cave)
			throws PlaceInsuffisanteException, BouteilleInexistanteException,
			CaveInexistanteException, BouteilleInvalideException, CaveInvalideException, BouteilleDejaExistanteException;
	
	public void ajouterBouteilles(Collection<Bouteille> bouteilles, Cave cave)
			throws PlaceInsuffisanteException, BouteilleInexistanteException,
			CaveInexistanteException, BouteilleInvalideException, CaveInvalideException;

	public void retirerBouteille(Bouteille bouteille)
			throws BouteilleInexistanteException, BouteilleInvalideException;

	public Bouteille obtenirBouteille(String reference);

	public List<Bouteille> obtenirBouteille(Predicate<Bouteille> condition, Cave cave);
	
	public Integer obtenirCapaciteRestante(Cave cave);
	
	public Boolean verifierCapaciteRestante(Integer nombreBouteilleAjouter, Cave cave);
	
}