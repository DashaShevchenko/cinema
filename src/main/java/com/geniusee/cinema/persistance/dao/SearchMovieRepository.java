package com.geniusee.cinema.persistance.dao;

import com.geniusee.cinema.persistance.entity.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchMovieRepository {
    private final MovieRepository movieRepository;

    public SearchMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllBySearchCriteria(List<SearchCriteria> searchCriteria, Pageable pageable){
        MovieSpecification spec =
                new MovieSpecification(searchCriteria);

        return movieRepository.findAll(spec, pageable).getContent();
    }
}
