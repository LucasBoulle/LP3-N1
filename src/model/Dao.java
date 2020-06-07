package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao<DomainObject> {
	
	public void insert(DomainObject obj) throws SQLException;
	
	public Object update(DomainObject obj) throws SQLException;
	
	public void delete(int id) throws SQLException;
	
	public Object find(int id) throws SQLException;
	
	public ArrayList<DomainObject> findAll(DomainObject obj);
	
}
