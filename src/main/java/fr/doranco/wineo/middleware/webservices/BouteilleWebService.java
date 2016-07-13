package fr.doranco.wineo.middleware.webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.doranco.wineo.middleware.objetmetier.bouteille.Bouteille;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleDejaExistanteException;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInexistanteException;
import fr.doranco.wineo.middleware.objetmetier.bouteille.BouteilleInvalideException;
import fr.doranco.wineo.middleware.services.IBouteilleService;

@WebService
@Path("/bouteille")
public class BouteilleWebService {
	
	@EJB
	private IBouteilleService bouteilleService;

	@GET
	@Path("/{reference}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Bouteille obtenirBouteille(
			@PathParam("reference") String reference
	) throws BouteilleInexistanteException {
		
		/*
		 * Nous déléguons au service, la responsabilité
		 * de connaitre les règles métier d'obtention d'une bouteille.
		 */
		return bouteilleService.obtenirBouteille(reference);
	}
	
	@GET
	public List<Bouteille> obtenirBouteilles() {
		return null;
	}
	
	@POST
	public String creerBouteille(
			@FormParam("contenance") double contenance,
			@FormParam("designation") String designation,
			@FormParam("annee") int annee
	) throws BouteilleInvalideException, BouteilleDejaExistanteException {
		
		/*
		 * Nous transformons les paramètres d'entrée du WS en un objet métier. 
		 */
		final Bouteille bouteille = new Bouteille();
		bouteille.setAnnee(annee);
		bouteille.setContenance(contenance);
		bouteille.setDesignation(designation);
		
		return bouteilleService.consignerBouteille(bouteille);
	}
	
	@PUT
	public Bouteille modifierBouteille(
			@FormParam("reference") String reference,
			@FormParam("contenance") double contenance,
			@FormParam("designation") String designation,
			@FormParam("annee") int annee
	) {
		return null;
	}
	
	@DELETE
	@Path("/{reference}")
	public Response supprimerBouteille(
			@PathParam("reference") String reference
	) {
		
		return Response.ok().build();
	}
	
}
