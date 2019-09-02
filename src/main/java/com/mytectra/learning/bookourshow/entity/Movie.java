package com.mytectra.learning.bookourshow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

@Entity
@Table(name = "movies")
public class Movie {
	
	@NotNull
	@Positive(message = "Id cannot be negative")
	@Id
	private Integer id;
	
	@Column(name = "movie_name" ,nullable = false)
	@NotBlank(message = "Movie name cannot be null")
	private String movieName;
	
	@Column	
	private String info;
	
	@Column(name = "actor_name")
	@NotBlank(message = "actor name cannot be null")
	private String actorName;
	
	@Column(name = "director_name")
	@NotBlank(message = "director name cannot be null")
	private String directorName;
	
	@Column
	@Max(value = 10 , message = "cannot grater than 10")
	@PositiveOrZero(message = "cannot be negative")
	private Integer imdb;
	
	@Column(name = "release_date")
	@NotNull(message = "Movie release date cannot be null")
	@JsonFormat(lenient = OptBoolean.FALSE , pattern = "dd-MM-yyyy")
	private Date releaseDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getImdb() {
		return imdb;
	}

	public void setImdb(Integer imdb) {
		this.imdb = imdb;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	
	

}
