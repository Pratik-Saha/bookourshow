package com.mytectra.learning.bookourshow.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.MovieDao;
import com.mytectra.learning.bookourshow.entity.Movie;

@Component
public class MovieDaoJDBCImpl  implements MovieDao{

	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private MovieMapper mapper;
	
	private final String SELECT_ALL_QUERY = "select * from  movies";
	
	private final String SELECT_QUERY = "select * from  movies where id = ?";
	
	private final String INSERT_QUERY = "insert into movies (id, actor_name, director_name, movie_name,release_date, imdb, info) values (?,?,?,?,?,?,?)";
	
	private final String UPDATE_QUERY = "update movies set actor_name =?, director_name =?, movie_name =? ,release_date =?, imdb =?, info =? where id =?";

	private final String DELETE_QUERY = "DELETE from movies where id =?";

	
	@Override
	public Movie findMovieById(Integer id) {
		List<Movie> movies = template.query(SELECT_QUERY, new Object[] {id}, mapper );
		if(movies == null || movies.isEmpty()) {
			return null;
		}
		return movies.get(0);
	}

	@Override
	public int saveMovie(Movie movie) {
		return template.update(INSERT_QUERY, new Object[] {movie.getId() , movie.getActorName() , 
				movie.getDirectorName() , movie.getMovieName() , movie.getReleaseDate() , movie.getImdb() , movie.getInfo()});
	}

	@Override
	public int update(Movie movie) {
		return template.update(UPDATE_QUERY, new Object[] {movie.getActorName() , 
				movie.getDirectorName() , movie.getMovieName() , movie.getReleaseDate() , movie.getImdb() , movie.getInfo() ,movie.getId()});
	}

	@Override
	public int delete(Movie movie) {
		
		return template.update(DELETE_QUERY, new Object[] {movie.getId()});
	}

	@Override
	public List<Movie> getAllMovies() {
		return template.query(SELECT_ALL_QUERY, mapper );
	}

}
