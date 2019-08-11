package com.mytectra.learning.bookourshow.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {MovieController.class})
public class MovieContollerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private MovieService movieService;
	
	List<Movie> movies;
	
	@Before
	public void setUp() {
		
		movies = new ArrayList<>();
		
		Movie movie1 = new Movie();
		movie1.setId(1);
		movie1.setActorName("SRK");
		movie1.setDirectorName("karan");
		movie1.setImdb(8);
		movie1.setMovieName("msd");
		movie1.setReleaseDate(new Date());
		
		Movie movie2 = new Movie();
		movie2.setId(2);
		movie2.setActorName("SRK");
		movie2.setDirectorName("karan");
		movie2.setImdb(8);
		movie2.setMovieName("msd");
		movie2.setReleaseDate(new Date());
		
		movies.add(movie1);
		movies.add(movie2);
		
	}
	
	@Test
	public void testLoadMovie() throws Exception {
		
		String movie = "{"
				+ "\"id\" : 9,"
				+ "\"movieName\" : \"msd2\","
				+ "\"info\" : \"English\","
				+ "\"actorName\" : \"simran\","
				+ "\"directorName\" : \"karan\","
				+ "\"imdb\" : 9,"
				+ "\"releaseDate\" : \"02-12-2012\""
				+ "}\"";
		
		mvc.perform(MockMvcRequestBuilders.post("/bookourshow/movies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(movie))
		
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andExpect(MockMvcResultMatchers.jsonPath("status").value("SUCCESS"));
		
		System.out.println("SOM");
		Mockito.verify(movieService).loadMovie(Matchers.any(Movie.class));
		
		
		
	}
	
	
	@Test
	public void testLoadInvalidJsonMovie() throws Exception {
		
		String movie = "{"
				+ "\"id\" : 9"
				+ "\"movieName\" : \"msd2\","
				+ "\"info\" : \"English\","
				+ "\"actorName\" : \"simran\","
				+ "\"directorName\" : \"karan\","
				+ "\"imdb\" : 9,"
				+ "\"releaseDate\" : \"02-12-2012\""
				+ "}\"";
		
		mvc.perform(MockMvcRequestBuilders.post("/bookourshow/movies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(movie))
		
		.andExpect(MockMvcResultMatchers.status().is(400))
		.andExpect(MockMvcResultMatchers.jsonPath("status").value("ERROR"));
		
		Mockito.verifyZeroInteractions(movieService);
		
		
		
	}
	
	@Test
	public void testLoadInvalidJsonFieldMovie() throws Exception {
		
		String movie = "{"
				+ "\"id\" : 9,"
				+ "\"movieName\" : \"msd2\","
				+ "\"info\" : \"English\","
				+ "\"actorName\" : \"simran\","
				+ "\"directorName\" : \"karan\","
				+ "\"imdb\" : -9,"
				+ "\"releaseDate\" : \"02-12-2012\""
				+ "}\"";
		
		mvc.perform(MockMvcRequestBuilders.post("/bookourshow/movies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(movie))
		
		.andExpect(MockMvcResultMatchers.status().is(400))
		.andExpect(MockMvcResultMatchers.jsonPath("status").value("INVALID_REQUEST"))
		.andExpect(MockMvcResultMatchers.jsonPath("response.errorMessage").value(org.hamcrest.Matchers.containsString("negative")));
		
		Mockito.verifyZeroInteractions(movieService);
			
	}
	
	@Test
	public void testGetMovie() throws Exception {
		
		Mockito.when(movieService.getMovieById(1)).thenReturn(movies.get(0));
		
		mvc.perform(MockMvcRequestBuilders.get("/bookourshow/getMovieById/1")
				.requestAttr("id", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andExpect(MockMvcResultMatchers.jsonPath("status").value("SUCCESS"))
		.andExpect(MockMvcResultMatchers.jsonPath("response.id").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("response.actorName").value("SRK"));
		
	}
	
	@Test
	public void testDeletetMovie() throws Exception {
		
		Mockito.when(movieService.deleteMovie(1)).thenReturn(true);
		
		mvc.perform(MockMvcRequestBuilders.delete("/bookourshow/movies/1")
				.requestAttr("id", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andExpect(MockMvcResultMatchers.jsonPath("status").value("SUCCESS"));
		
		Mockito.verify(movieService).deleteMovie(1);
	}
	
	@Test
	public void testDeletetMovieWithInvalidId() throws Exception {
		
		Mockito.when(movieService.deleteMovie(3)).thenThrow(MovieNotFoundException.class);
		
		mvc.perform(MockMvcRequestBuilders.delete("/bookourshow/movies/3")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		
		.andExpect(MockMvcResultMatchers.status().is(404))
		.andExpect(MockMvcResultMatchers.jsonPath("status").value("INVALID_REQUEST"))
		.andExpect(MockMvcResultMatchers.jsonPath("response.errorCode").value("1114"));
		
		Mockito.verify(movieService).deleteMovie(3);
	}
	
	@Test
	public void testUpdateMovie() throws Exception {
		
		String movie3 = "{"
				+ "\"id\" : 1,"
				+ "\"movieName\" : \"msd3\","
				+ "\"info\" : \"hindi\","
				+ "\"actorName\" : \"simran\","
				+ "\"directorName\" : \"karan\","
				+ "\"imdb\" : 9,"
				+ "\"releaseDate\" : \"02-12-2012\""
				+ "}\"";
		
		Mockito.when(movieService.updateMovie(Matchers.eq(1), Matchers.any(Movie.class))).thenReturn(true);
		
		mvc.perform(MockMvcRequestBuilders.put("/bookourshow/movies/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(movie3))
		
		
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andExpect(MockMvcResultMatchers.jsonPath("status").value("SUCCESS"));
		
		//Mockito.verify(movieService).updateMovie(Matchers.eq(1), Matchers.any(Movie.class));
	}

}
