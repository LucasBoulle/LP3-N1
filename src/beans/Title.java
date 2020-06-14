package beans;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Title {
	
	private int id;
	private String title;
	private String genre;
	private Date publishedAt; 
	private String bannerImageUrl;
	private Publisher publisher;
	private Demographic demographic;
	
	public Demographic getDemographic() {
		return demographic;
	}
	public void setDemographic(Demographic demographic) {
		this.demographic = demographic;
	}
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
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Date getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	
	public String getBannerImageUrl() {
		return bannerImageUrl;
	}
	public void setBannerImageUrl(String bannerImageUrl) {
		this.bannerImageUrl = bannerImageUrl;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", this.id);
		jsonObj.put("title", this.title);
		jsonObj.put("genre", this.genre);
		jsonObj.put("bannerImageUrl", this.bannerImageUrl);
		jsonObj.put("publishedAt", this.publishedAt.toString());
		jsonObj.put("publisher", this.publisher.toJson());
		jsonObj.put("demographic", this.demographic.toJson());

		return jsonObj;
	}
}
