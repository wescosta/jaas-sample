package br.com.java.samples.jaas.servlet;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.java.samples.jaas.model.User;
import br.com.java.samples.jaas.repository.UserRepository;

@WebServlet("/private/users")
@RequestScoped
@ServletSecurity(httpMethodConstraints = {
	@HttpMethodConstraint(value = "GET", rolesAllowed = {"USER", "ADMIN"}),
	@HttpMethodConstraint(value = "POST", rolesAllowed = {"ADMIN"})
})
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final String FORM_VIEW = "/WEB-INF/view/users/user-form.jsp";
	private static final String LIST_VIEW = "/WEB-INF/view/users/user-list.jsp";
	
	@Inject
	private UserRepository repository;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			form(request, response);
		} else {
			list(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object id = request.getParameter("id");
		Object login = request.getParameter("login");
		Object password = request.getParameter("password");
		
		User user = new User();
		
		if (id != null)
			user.setId((Long) id);
		
		user.setLogin((String) login);
		user.setPassword((String) password);
		
		repository.save(user);
		
		list(request, response);
	}
	
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(FORM_VIEW).forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", repository.list());
		request.getRequestDispatcher(LIST_VIEW).forward(request, response);
	}
	
}