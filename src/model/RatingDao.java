package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.Rating;

public class RatingDao implements Dao<Rating> {
	
	private Connection connection;

	public RatingDao() {
		this.connection = UtilDb.getConnection();
	}

	@Override
	public void insert(Rating rating) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into ratings (rating, comment, \"userId\", \"titleId\", \"createdAt\") values (?, ?, ?, ?, ?)");
		preparedStatement.setInt(1, (rating.getRating()));
		preparedStatement.setString(2, (rating.getComment()));
		preparedStatement.setInt(3, (rating.getUser().getId()));
		preparedStatement.setInt(4, (rating.getTitle().getId()));
		preparedStatement.setDate(5, rating.getCreatedAt());

		preparedStatement.execute();
	}

	@Override
	public Rating update(Rating rating) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"update ratings set rating = ?, comment = ?, \"userId\" = ?, \"titleId\" = ?, \"createdAt\" = ? where id = ?");
		preparedStatement.setInt(1, (rating.getRating()));
		preparedStatement.setString(2, (rating.getComment()));
		preparedStatement.setInt(3, (rating.getUser().getId()));
		preparedStatement.setInt(4, (rating.getTitle().getId()));
		preparedStatement.setDate(5, rating.getCreatedAt());
		preparedStatement.setInt(6, rating.getId());

		preparedStatement.execute();
		
		return rating;
	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("delete from ratings where id = ?");
		preparedStatement.setInt(1, id);

		preparedStatement.execute();
		
	}

	@Override
	public Object find(int id) throws SQLException {
		Rating rating = new Rating();
		UserDao userDao = new UserDao();
		TitleDao titleDao = new TitleDao();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ratings WHERE id=?");

		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			rating.setId(rs.getInt("id"));
			rating.setRating(rs.getInt("rating"));
			rating.setComment(rs.getString("comment"));
			rating.setUser(userDao.find(rs.getInt("userId")));
			rating.setTitle(titleDao.find(rs.getInt("titleId")));
			rating.setCreatedAt(rs.getDate("createdAt"));
		} else {
			throw new SQLException("Review não encontrado!");
		}

		return rating;
	}

	@Override
	public ArrayList<Rating> findAll(Rating obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
