package com.Project.App.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AllNews {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	private String image;
	private String discription;
	private String fullInformation;
	@Column(columnDefinition = "int default 0")
    private int Rate;
	public int getRate() {
		return Rate;
	}
	public void setRate(int rate) {
		Rate = rate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
