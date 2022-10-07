package com.geniusee.cinema;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geniusee.cinema.dto.MovieDto;
import com.geniusee.cinema.persistance.dao.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CinemaApplicationTests {
    @Autowired
    MockMvc mvc;

    @Test
    void getMovies() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        MvcResult mvcResult = this.mvc.perform(get("/movies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        List<MovieDto> movieDtos = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<List<MovieDto>>(){});
        assertThat(movieDtos).hasSize(3);
    }

    @Test
    void getMoviesByNameLikeAndPageSize() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        MvcResult mvcResult = this.mvc.perform(get("/movies?search=name:Avatar&size=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        List<MovieDto> movieDtos = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<List<MovieDto>>(){});
        assertThat(movieDtos).hasSize(1);
    }
}
