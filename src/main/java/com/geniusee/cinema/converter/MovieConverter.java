package com.geniusee.cinema.converter;

import com.geniusee.cinema.dto.MovieDto;
import com.geniusee.cinema.dto.TicketDto;
import com.geniusee.cinema.persistance.entity.Movie;

public class MovieConverter extends DtoConverter<Movie, MovieDto> {

    @Override
    public MovieDto toDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setDuration(movie.getDuration());
        movieDto.setName(movie.getName());
        return movieDto;
    }

    @Override
    public Movie fromDto(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setDuration(movieDto.getDuration());
        movie.setName(movieDto.getName());
        return movie;
    }
}
