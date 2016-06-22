package fr.doranco.wineo.middleware.services;

import java.util.List;
import java.util.function.Predicate;

import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.cave.Cave;
import fr.doranco.wineo.middleware.objetmetier.cave.PlaceInsuffisanteException;

public class CaveService implements ICaveService {

	@Override
	public void ajouterBouteille(Bouteille bouteille, Cave cave) throws PlaceInsuffisanteException {
		
	}

	@Override
	public void retirerBouteille(Bouteille bouteille) {
		// TODO Auto-generated method stub
	}

	@Override
	public Bouteille obtenirBouteille(String reference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bouteille> obtenirBouteille(Predicate<Bouteille> condition, Cave cave) {
		// TODO Auto-generated method stub
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

}
