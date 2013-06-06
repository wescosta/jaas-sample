package br.com.java.samples.jaas.model;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@XmlRootElement
public class User implements Principal, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String login;
	
	@NotNull
	@Size(max = 8, message = "Max Size: 8")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private List<Role> roles;
	
	public User() {
	}
	
	public User(String login, String password, List<Role> roles) {
		this.login = login;
		this.password = password;
		this.setRoles(roles);
	}
	
	public User(String login, String password, String ... roles) {
		this(login, password, new ArrayList<Role>());
		
		for (String role : roles) {
			this.getRoles().add(new Role(role));
		}
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return login;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof User)) return false;
		
		User user = (User) obj;
		
		if (id != null && user.getId() != null)
			return id.equals(user.getId());
		
		if (login != null && password != null)
			return login.equals(user.getLogin()) && password.equals(user.getPassword());
		
		return false;
	}
	
}