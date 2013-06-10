package br.com.java.samples.jaas.test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.java.samples.jaas.model.User;
import br.com.java.samples.jaas.rest.UserService;
import br.com.java.samples.jaas.test.selenium.util.Deployments;

@RunWith(Arquillian.class)
public class UserServiceTest {
	
	@Deployment
	public static Archive<?> userServiceDeployment() {
		return Deployments.userServiceDeployment();
	}
	
//	@ArquillianResource(UserService.class)
//    private URL deploymentUrl;
	
	@Inject
	private UserService service;
	
//	private String restUrl = deploymentUrl + "/rest/users";
	private String restUrl = "http://localhost:8080/test/rest/users";
	
	private User user = new User("any_login", "any_pass", "admin", "manager");
	
	@Test
	@InSequence(1)
	public void shouldRegisterANewUser() {
		Response response = service.save(user);
		
		assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));
	}
	
	@Test
	@InSequence(2)
	public void shouldRetriveTheRegisteredUser() {
		List<User> users = service.list();
		
		assertThat(users, hasItem(user));
	}
	
	@Test
	@InSequence(3)
	@RunAsClient
	public void shouldAccessTheUserListAsRestClient() {
		Client client = ClientBuilder.newClient();
		List<User> users = client.target(restUrl).request(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>(){});
		
		assertThat(users, hasItem(user));
	}
	
	
}