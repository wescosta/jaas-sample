package br.com.java.samples.jaas.model;

import java.io.Serializable;
import java.security.Principal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@XmlRootElement
public class User implements Principal, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String login;
	
	@NotNull
	@Size(min = 4, max = 8, message = "Size 4-8")
	private String password;
	
	public User() {
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
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