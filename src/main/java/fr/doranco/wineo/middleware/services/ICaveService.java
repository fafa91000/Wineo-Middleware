package fr.doranco.wineo.middleware.services;

import java.util.List;
import java.util.function.Predicate;

import fr.doranco.wineo.middleware.objetmetier.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.Cave;

public interface ICaveService {

	public void ajouterBouteille(Bouteille bouteille, Cave cave)
			throws PlaceInsuffisanteException, CaveInvalideException, CaveInexistanteException,
			BouteilleInexistanteException, BouteilleInvalideException;

	public void retirerBouteille(Bouteille bouteille);

	public Bouteille obtenirBouteille(String reference);

	public List<Bouteille> obtenirBouteille(Predicate<Bouteille> condition, Cave cave);
	
	public Integer obtenirCapaciteRestante(Cave cave);
	
	public Boolean verifierCapaciteRestante(Integer nombreBouteilleAjouter, Cave cave);
	
}