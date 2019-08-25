package com.mytectra.learning.bookourshow.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;

@Component
public class MovieMapper implements RowMapper<Movie> {

	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movie movie = new Movie();
		movie.setId(rs.getInt("id"));
		movie.setMovieName(rs.getString("movie_name"));
		movie.setActorName(rs.getString("actor_name"));
		movie.setDirectorName(rs.getString("director_name"));
		movie.setReleaseDate(new Date(rs.getDate("release_date").getTime()));
		movie.setImdb(rs.getInt("imdb"));
		movie.setInfo(rs.getString("info"));
		return movie;
	}

}
