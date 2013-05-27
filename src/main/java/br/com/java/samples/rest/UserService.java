package br.com.java.samples.rest;

import static java.util.logging.Level.WARNING;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.java.samples.model.User;
import br.com.java.samples.repository.UserRepository;

@Path("/users")
@RequestScoped
@Stateful
public class UserService {
	
//	@Inject
//	private Logger log;
	
	@Inject
	private UserRepository repository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(User user) {
		Response.ResponseBuilder builder = Response.ok();
		
		try {
			repository.save(user);
		} catch (Exception e) {
//			log.log(WARNING, "Error on try to save a user", e);
			builder = Response.serverError();
		}
		
		return builder.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list() {
		return repository.list();
	}
	
}