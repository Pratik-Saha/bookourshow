package com.mytectra.learning.bookourshow.dao.orm;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mytectra.learning.bookourshow.entity.Movie;

@RepositoryRestResource(collectionResourceRel="movies" , path = "/rest" )
public interface MovieDataRest extends PagingAndSortingRepository<Movie, Integer> {

}
