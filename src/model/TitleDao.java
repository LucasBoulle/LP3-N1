package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Title;

public class TitleDao implements Dao<Title> {
	
	private Connection connection;

	public TitleDao() {
		this.connection = UtilDb.getConnection();
	}

	@Override
	public void insert(Title title) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into titles (title, genre, \"demographicId\", \"publisherId\", \"publishedAt\", \"bannerImageUrl\") values (?, ?, ?, ?, ?, ? )");
		preparedStatement.setString(1, (title.getTitle()));
		preparedStatement.setString(2, (title.getGenre()));
		preparedStatement.setInt(3, (title.getDemographic().getId()));
		preparedStatement.setInt(4, (title.getPublisher().getId()));
		preparedStatement.setDate(5, title.getPublishedAt());
		preparedStatement.setString(6, (title.getBannerImageUrl()));

		preparedStatement.execute();
	}

	@Override
	public Title update(Title title) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"update titles set title = ?, genre = ?, \"demographicId\" = ?, \"publisherId\" = ?, \"publishedAt\" = ?, \"bannerImageUrl\" = ? where id = ?");
		preparedStatement.setString(1, (title.getTitle()));
		preparedStatement.setString(2, (title.getGenre()));
		preparedStatement.setInt(3, (title.getDemographic().getId()));
		preparedStatement.setInt(4, (title.getPublisher().getId()));
		preparedStatement.setDate(5, title.getPublishedAt());
		preparedStatement.setString(6, (title.getBannerImageUrl()));
		preparedStatement.setInt(7, (title.getId()));

		preparedStatement.execute();
		
		return title;
	}

	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("delete from titles where id = ?");
		preparedStatement.setInt(1, id);

		preparedStatement.execute();
	}

	@Override
	public Title find(int id) throws SQLException {
		Title title = new Title();
		DemographicDao demographicDao = new DemographicDao();
		PublisherDao publisherDao = new PublisherDao();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM titles WHERE id=?");

		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			title.setId(rs.getInt("id"));
			title.setTitle(rs.getString("title"));
			title.setGenre(rs.getString("genre"));
			title.setDemographic(demographicDao.find(rs.getInt("demographicId")));
			title.setPublisher(publisherDao.find(rs.getInt("publisherId")));
			title.setPublishedAt(rs.getDate("publishedAt"));
			title.setBannerImageUrl(rs.getString("bannerImageUrl"));
		} else {
			throw new SQLException("Título não encontrado!");
		}

		return title;
	}

	@Override
	public ArrayList<Title> findAll(Title obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
