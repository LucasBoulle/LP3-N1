package beans;

public class Title {
	
	private int Id;
	private String title;
	private String genre;
	private String publishedAt; 
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
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	
	public String getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(String publishedAt) {
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
}
