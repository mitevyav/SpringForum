package com.yavor.mvc.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yavor.mvc.entities.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	
	
	private JdbcTemplate template;
	
	private static final String RETURN_ALL_CATEGORIES = "SELECT * FROM category";
	private static final String RETURN_NUMBER_OF_TOPICS = "SELECT COUNT(id) FROM topic WHERE category_id = ?";
	private static final String RETURN_NUMBER_OF_COMMENTS = "SELECT COUNT(comments.id) FROM topic RIGHT JOIN comments ON"
			+ " topic.id = comments.topic_id WHERE topic.category_id = ?";
	
	@Autowired
	public CategoryRepositoryImpl (DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public List<Category> findAllCategories() {
		return this.template.query(RETURN_ALL_CATEGORIES, new CategoryRowMapper());
	}
	
	private static class CategoryRowMapper implements RowMapper<Category> {
		
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(Integer.toString(rs.getInt("id")));
			category.setName(rs.getString("name"));
			return category;
		}
		
		
	}
	
	@Override
	public void insert(Category entitiy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String numberOfTopics(String id) {
		Integer count = this.template.queryForObject(RETURN_NUMBER_OF_TOPICS, new Object[] {id}, Integer.class);
		return Integer.toString(count);
	}

	@Override
	public String numberOfComments(String id) {
		Integer count = this.template.queryForObject(RETURN_NUMBER_OF_COMMENTS, new Object[] {id}, Integer.class);
		return Integer.toString(count);
	}
	
	
	

}
