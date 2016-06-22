package fr.doranco.wineo.middleware.services;

import java.util.List;
import java.util.function.Predicate;

import fr.doranco.wineo.middleware.objetmetier.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.cave.Cave;
import fr.doranco.wineo.middleware.objetmetier.cave.PlaceInsuffisanteException;

public interface ICaveService {

	// , CaveInvalideException, CaveInexistanteException, BouteilleInexistanteException, BouteilleInvalideException
	public void ajouterBouteille(Bouteille bouteille, Cave cave) throws PlaceInsuffisanteException;

	public void retirerBouteille(Bouteille bouteille);

	public Bouteille obtenirBouteille(String reference);

	public List<Bouteille> obtenirBouteille(Predicate<Bouteille> condition, Cave cave);
	
	public Integer obtenirCapaciteRestante(Cave cave);
	
	public Boolean verifierCapaciteRestante(Integer nombreBouteilleAjouter, Cave cave);
	
}