package beans;

import org.json.JSONException;
import org.json.JSONObject;

public class Demographic {
	private int id;
	private String title;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("title", this.title);
		
		return jsonObj;
	}
}
