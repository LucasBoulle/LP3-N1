package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.User;

public class UserDao implements Dao<User> {

	private Connection connection;

	public UserDao() {
		this.connection = UtilDb.getConnection();
	}

	@Override
	public void insert(User user) throws SQLException {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into users (nickname, email, \"profileImageUrl\", \"createdAt\") values (?,?,?,?)");
			preparedStatement.setString(1, user.getNickname());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getProfileImageUrl());
			preparedStatement.setDate(4, user.getCreatedAt());

			preparedStatement.execute();
	}

	@Override
	public Object update(User user) throws SQLException {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update users set nickname = ?, email = ?, \"profileImageUrl\" = ?, \"createdAt\" = ? where id = ?");
			
			
			preparedStatement.setString(1, user.getNickname());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getProfileImageUrl());
			preparedStatement.setDate(4, user.getCreatedAt());
			preparedStatement.setInt(5, user.getId());

			preparedStatement.execute();
			
			return user;
	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?");
		preparedStatement.setInt(1, id);

		preparedStatement.execute();
	}

	@Override
	public Object find(int id) throws SQLException {

		User user = new User();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?");

		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			user.setNickname(rs.getString("nickname"));
			user.setEmail(rs.getString("email"));
			user.setProfileImageUrl(rs.getString("profileImageUrl"));
			user.setCreatedAt(rs.getDate("createdAt"));
		}

		return user;
	}

	@Override
	public ArrayList<User> findAll(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
