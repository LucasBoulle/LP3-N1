package beans;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Rating {
	private int id;
	private int rating;
	private String comment;
	private Date createdAt;
	private Title title;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("rating", this.rating);
		jsonObj.put("comment", this.comment);
		jsonObj.put("createdAt", this.createdAt);
		jsonObj.put("title", this.title.toJson());
		jsonObj.put("user", this.user.toJson());

		return jsonObj;
	}
}
