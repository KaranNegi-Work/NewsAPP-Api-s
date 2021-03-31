package com.Project.App.UserRequestBody;

public class UserPostRequest {
	private String image;
	private String discription;
	private String fullInformation;

	
//	public UserPostRequest(String image, String discription, String fullInformation) {
//		super();
//		this.image = image;
//		this.discription = discription;
//		this.fullInformation = fullInformation;
//	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getFullInformation() {
		return fullInformation;
	}
	public void setFullInformation(String fullInformation) {
		this.fullInformation = fullInformation;
	}

}
