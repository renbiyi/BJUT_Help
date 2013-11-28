package cn.edu.bjut.help.core.bo;

import java.io.Serializable;

public class Role implements Serializable {

	/*
	public static enum Role {
		ROLE_ADMIN,
		ROLE_USER
	}
	*/
	
	private static final long serialVersionUID = 2619123694997850172L;
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
