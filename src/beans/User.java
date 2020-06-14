package beans;


import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
	private int id;
	private String email;
	private String nickname;
	private String profileImageUrl;
	private Date createdAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	

	public JSONObject toJson() throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("nickname", this.nickname);
		jsonObj.put("email", this.email);
		jsonObj.put("profileImageUrl", this.profileImageUrl);
		jsonObj.put("createdAt", this.createdAt.toString());

		return jsonObj;
	}

}
