package com.yavor.mvc.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yavor.mvc.entities.Topic;

@Repository
public class TopicRepositoryIml implements TopicRepository {
	
	private JdbcTemplate template;
	
	private static final String GET_TOPICS_FOR_A_SPECIFIC_CATEGORY = "SELECT topic.id, "
			+ "topic.subject, topic.category_id, topic.date, topic.description, topic.post_by "
			+ " FROM topic WHERE category_id = ? ORDER BY topic.id";
	
	private static final String FIND_TOPIC_BY_ID = "SELECT topic.id, "
			+ "topic.subject, topic.category_id, topic.date, topic.description, topic.post_by "
			+ " FROM topic WHERE id = ?";
	
	private static final String INSERT_TOPIC = "INSERT INTO topic ( id, subject, "
			+ "category_id, post_by, date, description) values (NULL,?,?,?,?,?) ";
	
	private static final String RETURN_NUMBER_OF_COMMENTS = "SELECT COUNT(id) FROM comments WHERE topic_id = ?";
	
	@Autowired
	public TopicRepositoryIml (DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public List<Topic> getTopicsForCategory (String id) {
		return this.template.query(GET_TOPICS_FOR_A_SPECIFIC_CATEGORY, new Object[] {Integer.parseInt(id)}, new TopicRowMapper());
	}
	
	private static class TopicRowMapper implements RowMapper<Topic> {
		
		public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
			Topic topic = new Topic();
			topic.setId(Integer.toString(rs.getInt("id")));
			topic.setSubject(rs.getString("subject"));
			topic.setDate(rs.getString("date"));
			topic.setCategory(Integer.toString(rs.getInt("category_id")));
			topic.setDate(rs.getString("date"));
			topic.setUser(rs.getString("post_by"));
			topic.setDescription(rs.getString("description"));
			return topic;
		}
		
		
	}



	@Override
	public void insert(Topic entity) {

		this.template.update(INSERT_TOPIC, new Object[] {
				entity.getSubject(),
				Integer.parseInt(entity.getCategory()),
				entity.getUser(),
				entity.getDate(),
				entity.getDescription()	
				}
		);
	}

	@Override
	public void update(Topic entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Topic entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Topic findById(String id) {

		return this.template.queryForObject(FIND_TOPIC_BY_ID, new Object[] {Integer.parseInt(id)}, new TopicRowMapper());

	}

	@Override
	public String getCommentsCount(String id) {
		Integer count = this.template.queryForObject(RETURN_NUMBER_OF_COMMENTS, new Object[] {id}, Integer.class);
		return Integer.toString(count);
	}

}
