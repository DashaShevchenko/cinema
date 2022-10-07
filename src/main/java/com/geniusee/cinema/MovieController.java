package com.geniusee.cinema;

import com.geniusee.cinema.dto.MovieDto;
import com.geniusee.cinema.persistance.dao.SearchCriteria;
import com.geniusee.cinema.persistance.entity.Movie;
import com.geniusee.cinema.service.MovieService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping(path = "/movies")
    List<MovieDto> all(@PageableDefault(page = 0, size = 20)
                    Pageable pageable, @RequestParam(value = "search", required = false) String search) {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return service.findAllBySearchCriteria(params, pageable);
    }


    @PostMapping("/movies")
    MovieDto newMovie(@RequestBody Movie newMovie) {
        return service.saveMovie(newMovie);
    }

    @GetMapping("/movies/{id}")
    MovieDto one(@PathVariable Long id) {

        return service.findById(id);
    }

    @PutMapping("/movies/{id}")
    MovieDto replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id) {

        return service.putMovie(newMovie, id);
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        service.deleteById(id);
    }
}
