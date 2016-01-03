package com.yavor.mvc.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yavor.mvc.entities.CustomUser;


@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
	
	private JdbcTemplate template;
	
	
	private static final String FIND_USER_BY_NAME = "SELECT user.name, user.pass, "
			+ "user.role FROM user WHERE user.name = ?";
	
	private static final String INSERT_USER = "INSERT INTO user ( name, pass, "
			+ "role) values (?,?,?)";
	
	private static final String GET_USERNAME = "SELECT user.name FROM user WHERE user.name = ? ";
	
	
	@Autowired
	public CustomUserRepositoryImpl (DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	
	private static class CustomUserRowMapper implements RowMapper<CustomUser> {

		@Override
		public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustomUser user = new CustomUser();
			user.setPassword(rs.getString("pass"));
			user.setRole(rs.getString("role"));
			user.setUsername(rs.getString("name"));
			return user;
		}
		
	}
	
	@Override
	public void insert(CustomUser entitiy) {
		
		this.template.update(INSERT_USER, new Object[] {
				entitiy.getUsername(),
				entitiy.getPassword(),
				entitiy.getRole()
				}
		);

	}

	@Override
	public void update(CustomUser entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CustomUser entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomUser findById(String id) {
		System.out.println("FindById");
		return this.template.queryForObject(FIND_USER_BY_NAME, new Object[] {id}, new CustomUserRowMapper());
		
	}
	
	
	public String getUsername(String id) {
		 List<String> user = this.template.queryForList(GET_USERNAME, new Object[] {id}, String.class);
		 if (user.isEmpty()) {
		        return null;
		    } else {
		        return user.get(0);
		    }
		
	}
	
	
	
	

}
