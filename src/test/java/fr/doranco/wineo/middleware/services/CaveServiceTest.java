package fr.doranco.wineo.middleware.services;

import java.util.HashMap;

import org.fest.assertions.Assertions;
import org.junit.Assert;
import org.junit.Test;

import fr.doranco.wineo.middleware.objetmetier.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.cave.Cave;
import fr.doranco.wineo.middleware.objetmetier.cave.PlaceInsuffisanteException;

public class CaveServiceTest {

	@Test
	public void testAjouterBouteilleNominal() throws PlaceInsuffisanteException {

		// Initialisation du test
		CaveService caveService = new CaveService();

		Bouteille bouteille = new Bouteille();
		bouteille.setAnnee(2012);
		bouteille.setContenance(1d);
		bouteille.setDesignation("Ma bouteille de champomy");
		bouteille.setReference("REF_90");

		Cave cave = new Cave();
		cave.setBouteilles(new HashMap<>());
		cave.setCapaciteMaximale(10);
		cave.setNomProprietaire("Moi");
		cave.setReference("C7857FJG");
		Integer contenanceInitiale = cave.getBouteilles().size();

		// Lancement du test
		caveService.ajouterBouteille(bouteille, cave);

		// Vérification du test
		/*
		 * La condition de réussite du test est que la cave contienne la
		 * bouteille
		 */
		Assertions.assertThat(cave.getBouteilles().get(bouteille.getReference())).isEqualTo(bouteille);
		Assertions.assertThat(cave.getBouteilles().size()).isEqualTo(contenanceInitiale + 1);

	}

	@Test(expected = PlaceInsuffisanteException.class)
	public void testAjouterBouteillePlaceInsuffisante() throws PlaceInsuffisanteException {

		// Initialisation du test
		CaveService caveService = new CaveService();

		Bouteille bouteille = new Bouteille();
		bouteille.setAnnee(2012);
		bouteille.setContenance(1d);
		bouteille.setDesignation("Ma bouteille de champomy");
		bouteille.setReference("REF_90");

		Cave cave = new Cave();
		cave.setBouteilles(new HashMap<>());
		cave.setCapaciteMaximale(0);
		cave.setNomProprietaire("Moi");
		cave.setReference("IUUFHEUIFE");
		Integer contenanceInitiale = cave.getBouteilles().size();

		// Lancement du test
		caveService.ajouterBouteille(bouteille, cave);
	}

}
