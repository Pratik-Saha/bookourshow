package com.mytectra.learning.bookourshow.dao.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytectra.learning.bookourshow.entity.Movie;

@Repository
public interface MovieDaoRepository extends JpaRepository<Movie, Integer> {

	
}
