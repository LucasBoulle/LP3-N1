package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Demographic;

public class DemographicDao implements Dao<Demographic> {
	
	private Connection connection;

	public DemographicDao() {
		this.connection = UtilDb.getConnection();
	}

	@Override
	public void insert(Demographic demographic) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into demographics (title) values (?)");
		preparedStatement.setString(1, (demographic.getTitle()));

		preparedStatement.executeQuery();
	}

	@Override
	public Demographic update(Demographic demographic) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"update demographics set title = ? where id = ?");
		
		
		preparedStatement.setString(1, (demographic.getTitle()));
		preparedStatement.setInt(2, demographic.getId());

		preparedStatement.execute();
		
		return demographic;
	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("delete from demographics where id = ?");
		preparedStatement.setInt(1, id);

		preparedStatement.execute();
	}

	@Override
	public Demographic find(int id) throws SQLException {
		Demographic demographic = new Demographic();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM demographics WHERE id=?");

		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			demographic.setId(rs.getInt("id"));
			demographic.setTitle(rs.getString("title"));
		}

		return demographic;
	}

	@Override
	public ArrayList<Demographic> findAll(Demographic obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
