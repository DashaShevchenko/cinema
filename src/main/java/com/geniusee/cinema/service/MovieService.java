package com.geniusee.cinema.service;

import com.geniusee.cinema.converter.MovieConverter;
import com.geniusee.cinema.dto.MovieDto;
import com.geniusee.cinema.persistance.dao.SearchCriteria;
import com.geniusee.cinema.persistance.dao.SearchMovieRepository;
import com.geniusee.cinema.persistance.entity.Movie;
import com.geniusee.cinema.persistance.dao.MovieRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieService {
    private MovieConverter movieConverter = new MovieConverter();

    private final MovieRepository movieRepository;
    private final SearchMovieRepository searchMovieRepository;

    public MovieService(MovieRepository repository, SearchMovieRepository searchMovieRepository) {
        this.movieRepository = repository;
        this.searchMovieRepository = searchMovieRepository;
    }

    public MovieDto saveMovie(Movie newMovie){
        return movieConverter.toDto(movieRepository.save(newMovie));
    }

    public MovieDto findById(Long id){
        return movieConverter.toDto(movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id)));
    }

    public List<MovieDto> findAllBySearchCriteria(List<SearchCriteria> searchCriteria, Pageable pageable){
        return movieConverter.toDto(
                searchMovieRepository.findAllBySearchCriteria(searchCriteria, pageable));
    }

    public MovieDto putMovie(Movie newMovie, Long id){
        return movieConverter.toDto(movieRepository.findById(id)
                .map(movie -> {
                    movie.setName(newMovie.getName());
                    movie.setDuration(newMovie.getDuration());
                    return movieRepository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return movieRepository.save(newMovie);
                }));
    }

    public void deleteById(Long id){
        movieRepository.deleteById(id);
    }

    public void setMovieConverter(MovieConverter movieConverter) {
        this.movieConverter = movieConverter;
    }
}
