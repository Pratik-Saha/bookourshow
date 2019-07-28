package com.mytectra.learning.bookourshow.entity;

import java.util.Date;

import javax.management.MXBean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


public class Movie {
	
	@Positive(message = "connot be negative")
	private int id;
	
	@NotBlank(message = "Movie name cannot be null")
	private String movieName;
	
	private String info;
	
	@NotBlank(message = "Actor name cannot be null")
	private String actorName;
	
	@NotBlank(message = "Director name cannot be null")
	private String directorName;
	
	@NotNull
	private Date releaseDate;
	
	@Max(value = 10 , message = "cannot grater than 10")
	@PositiveOrZero(message = "connot be negative")
	private float imdb;

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public float getImdb() {
		return imdb;
	}

	public void setImdb(float imdb) {
		this.imdb = imdb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
