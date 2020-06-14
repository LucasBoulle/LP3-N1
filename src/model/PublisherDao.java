package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Publisher;

public class PublisherDao implements Dao<Publisher> {
	
	private Connection connection;

	public PublisherDao() {
		this.connection = UtilDb.getConnection();
	}

	@Override
	public void insert(Publisher publisher) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into publishers (\"fullName\", \"ownerName\", \"createdAt\") values (?,?,?)");
		preparedStatement.setString(1, publisher.getFullName());
		preparedStatement.setString(2, publisher.getOwnerName());
		preparedStatement.setDate(3, publisher.getCreatedAt());

		preparedStatement.execute();
	}

	@Override
	public Object update(Publisher publisher) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"update publishers set \"fullName\"= ?, \"ownerName\"= ? where id = ?");
		
		preparedStatement.setString(1, publisher.getFullName());
		preparedStatement.setString(2, publisher.getOwnerName());
		preparedStatement.setInt(3, publisher.getId());

		preparedStatement.execute();
		
		return publisher;
	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("delete from publishers where id = ?");
		preparedStatement.setInt(1, id);

		preparedStatement.execute();
		
	}

	@Override
	public Publisher find(int id) throws SQLException {
		Publisher publisher = new Publisher();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM publishers WHERE id=?");

		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			publisher.setId(rs.getInt("id"));
			publisher.setFullName(rs.getString("fullName"));
			publisher.setOwnerName(rs.getString("ownerName"));
			publisher.setCreatedAt(rs.getDate("createdAt"));
		} else {
			throw new SQLException("Editora não encontrada!");
		}

		return publisher;
	}

	@Override
	public ArrayList<Publisher> findAll(Publisher obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
