package beans;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Publisher {
	private int id;
	private String fullName;
	private Date createdAt;
	private String ownerName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("fullName", this.fullName);
		jsonObj.put("createdAt", this.createdAt.toString());
		jsonObj.put("ownerName", this.ownerName);

		return jsonObj;
	}
}
