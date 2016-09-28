package com.niit.collaboration.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ROLE")
@Component
public class Role {

	private String roleId;
	private String roleName;
	private Set<Users> user;

	@Id
	@Column(name = "ROLE_ID")
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(fetch=FetchType.EAGER,mappedBy="role")
	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Set<Users> user) {
		this.user = user;
	}

}
