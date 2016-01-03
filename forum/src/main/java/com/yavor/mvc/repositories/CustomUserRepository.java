package com.yavor.mvc.repositories;

import com.yavor.mvc.entities.CustomUser;

public interface CustomUserRepository extends Repo<CustomUser> {

	public String getUsername(String username);

	

}
