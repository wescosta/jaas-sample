package br.com.java.samples.jaas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ROLES")
@XmlRootElement
public class Role {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String role;
	
	public Role() {
	}
	
	public Role(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}