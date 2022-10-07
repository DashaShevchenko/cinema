package com.geniusee.cinema;

import com.geniusee.cinema.persistance.dao.MovieRepository;
import com.geniusee.cinema.persistance.dao.TicketRepository;
import com.geniusee.cinema.persistance.entity.Movie;
import com.geniusee.cinema.persistance.entity.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MovieRepository movieRepository, TicketRepository ticketRepository) {

        return args -> {
            log.info("Preloading ");

            Movie movie1 = movieRepository.save(new Movie("Avatar", 50));
            Movie movie2 = movieRepository.save(new Movie("Avatar 2", 62));
            Movie movie3 = movieRepository.save(new Movie("Crown", 85));
            ticketRepository.save(new Ticket(movie1, 12, 12, LocalDate.now()));
            ticketRepository.save(new Ticket(movie2, 12, 12, LocalDate.now()));
        };
    }
}
