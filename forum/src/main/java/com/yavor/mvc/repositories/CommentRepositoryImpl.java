package com.yavor.mvc.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yavor.mvc.entities.Comment;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
	
	private JdbcTemplate template;
	
	private static final String GET_COMMENTS_FOR_A_SPECIFIC_TOPIC = "SELECT comments.id, "
			+ "comments.content, comments.topic_id, comments.date, comments.comment_by "
			+ " FROM comments WHERE topic_id = ? ORDER BY comments.id";
	
	private static final String INSERT_COMMENT = "INSERT INTO comments ( id, content, "
			+ "topic_id, comment_by, date) values (NULL,?,?,?,?) ";

	
	@Autowired
	public CommentRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Comment> getCommentsForTopic(String id) {
		return this.template.query(GET_COMMENTS_FOR_A_SPECIFIC_TOPIC, new Object[] {Integer.parseInt(id)}, new CommentRowMapper());
	}
	
	
	private static class CommentRowMapper implements RowMapper<Comment> {

		@Override
		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comment comment = new Comment();
			comment.setContent(rs.getString("content"));
			comment.setDate(rs.getString("date"));
			comment.setId(Integer.toString(rs.getInt("id")));
			comment.setTopic(Integer.toString(rs.getInt("topic_id")));
			comment.setUser(rs.getString("comment_by"));
			return comment;
		}
		
	}
	
	@Override
	public void insert(Comment entity) {

		this.template.update(INSERT_COMMENT, new Object[] {
				entity.getContent(),
				Integer.parseInt(entity.getTopic()),
				entity.getUser(),
				entity.getDate()
				}
		);

	}

	@Override
	public void update(Comment entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Comment entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comment findById(String id) {

		return null;

	}

	

}
