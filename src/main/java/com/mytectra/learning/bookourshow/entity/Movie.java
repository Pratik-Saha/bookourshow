package com.mytectra.learning.bookourshow.entity;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

public class Movie {
	
	@NotNull
	@Positive(message = "Id cannot be negative")
	private int id;
	
	@NotBlank(message = "Movie name cannot be null")
	private String movieName;
	
	private String info;
	
	@NotBlank(message = "actor name cannot be null")
	private String actorName;
	
	@NotBlank(message = "director name cannot be null")
	private String directorName;
	
	@Max(value = 10 , message = "cannot grater than 10")
	@PositiveOrZero(message = "cannot be negative")
	private int imdb;
	
	@NotNull
	@JsonFormat(lenient = OptBoolean.FALSE , pattern = "dd-MM-yyyy")
	private Date releaseDate;

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

	public int getImdb() {
		return imdb;
	}

	public void setImdb(int imdb) {
		this.imdb = imdb;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	

}
