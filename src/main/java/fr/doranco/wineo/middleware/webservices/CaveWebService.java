package fr.doranco.wineo.middleware.webservices;

import java.time.Instant;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
@Path(value = "/cave")
public class CaveWebService {

	@GET
	@Produces(value = MediaType.APPLICATION_XML)
	public Instant bipbop() {
		
		return Instant.now();
	}
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Instant ping() {
		
		return Instant.now();
	}
	
}
