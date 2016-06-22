package fr.doranco.wineo.middleware.services;

import java.util.HashMap;
import java.util.Map;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;
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
	
	public void test_retirerBouteille_nominal() {
		
		// Initialisation
		CaveService caveService = new CaveService();
		
		Map<String, Bouteille> bouteilles = new HashMap<>();
		
		Bouteille bouteille1 = Mockito.mock(Bouteille.class);
		Bouteille bouteille2 = Mockito.mock(Bouteille.class);
		Bouteille bouteille3 = Mockito.mock(Bouteille.class);
		
		bouteilles.put("B1", bouteille1);
		bouteilles.put("B2", bouteille2);
		bouteilles.put("BOUTEILLE3", bouteille3);
		
		Cave cave = new Cave();
		cave.setBouteilles(bouteilles);
		cave.setCapaciteMaximale(10);
		cave.setNomProprietaire("Moi");
		cave.setReference("Coucou!");
		
		Integer nombreInitialBouteilles = cave.getBouteilles().size(); 
		
		// Lancement du test
		caveService.retirerBouteille(bouteille1);
		
		// Vérification du test
		
		/*
		 * Nous vérifions que le nombre de bouteilles total
		 * est bien n-1 après le retrait d'une bouteille.
		 */
		Assertions
			.assertThat(cave.getBouteilles().size())
			.isEqualTo(nombreInitialBouteilles - 1);
		
		/*
		 * Nous vérifions que la bouteille retirée n'existe plus
		 * dans la liste des bouteilles de la cave.
		 */
		Assertions
			.assertThat(cave.getBouteilles().containsKey("B1"))
			.isFalse();
		
	}
	
}
