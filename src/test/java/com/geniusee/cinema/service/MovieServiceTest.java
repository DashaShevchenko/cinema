package com.geniusee.cinema.service;

import com.geniusee.cinema.converter.MovieConverter;
import com.geniusee.cinema.dto.MovieDto;
import com.geniusee.cinema.persistance.dao.MovieRepository;
import com.geniusee.cinema.persistance.dao.MovieSpecification;
import com.geniusee.cinema.persistance.dao.SearchCriteria;
import com.geniusee.cinema.persistance.dao.SearchMovieRepository;
import com.geniusee.cinema.persistance.entity.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService service;

    @Test
    public void getMoviesByName() throws Exception {
        SearchCriteria searchCriteria = new SearchCriteria("name", ":", "Avatar");
        List<MovieDto> movies = service.findAllBySearchCriteria(Collections.singletonList(searchCriteria), PageRequest.of(0, 10));
        assertThat(movies).hasSize(2);
        movies.stream().filter(movieDto -> movieDto.getName().equals("Avatar")).findFirst().orElseThrow(() -> new Exception("Entity not found"));
        movies.stream().filter(movieDto -> movieDto.getName().equals("Avatar 2")).findFirst().orElseThrow(() -> new Exception("Entity not found"));
    }

    @Test
    public void getMoviesByNameAndPageSize(){
        SearchCriteria searchCriteria = new SearchCriteria("name", ":", "Avatar");
        List<MovieDto> movies = service.findAllBySearchCriteria(Collections.singletonList(searchCriteria), PageRequest.of(0, 1));
        assertThat(movies).hasSize(1);
    }

    @Test
    public void getMoviesByDuration() throws Exception {
        SearchCriteria searchCriteria = new SearchCriteria("duration", ">", "60");
        List<MovieDto> movies = service.findAllBySearchCriteria(Collections.singletonList(searchCriteria), PageRequest.of(0, 10));
        assertThat(movies).hasSize(2);
        movies.stream().filter(movieDto -> movieDto.getName().equals("Avatar 2")).findFirst().orElseThrow(() -> new Exception("Entity not found"));
        movies.stream().filter(movieDto -> movieDto.getName().equals("Crown")).findFirst().orElseThrow(() -> new Exception("Entity not found"));
    }

}
