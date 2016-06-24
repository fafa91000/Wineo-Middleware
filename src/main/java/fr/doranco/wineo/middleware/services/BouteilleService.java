package fr.doranco.wineo.middleware.services;

import java.util.List;
import java.util.function.Predicate;

import javax.ejb.Stateless;

import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInvalideException;
import fr.doranco.wineo.middleware.objetmetier.contexte.ContexteConsommation;
import fr.doranco.wineo.middleware.objetmetier.contexte.ContexteConsommationInvalideException;
import fr.doranco.wineo.middleware.objetmetier.fournisseur.Fournisseur;

@Stateless
public class BouteilleService implements IBouteilleService {

	@Override
	public List<Bouteille> obtenirBouteilles(Predicate<Bouteille> condition) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exister(Predicate<Bouteille> condition) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Bouteille> selectionnerBouteilles(ContexteConsommation contexte)
			throws IllegalArgumentException, ContexteConsommationInvalideException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bouteille> obtenirBouteillesSemblables(Bouteille bouteille)
			throws BouteilleInvalideException, BouteilleInexistanteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fournisseur> obtenirVendeurs(Bouteille bouteille)
			throws BouteilleInvalideException, BouteilleInexistanteException {
		// TODO Auto-generated method stub
		return null;
	}

}
