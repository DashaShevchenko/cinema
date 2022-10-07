package com.geniusee.cinema;

import com.geniusee.cinema.persistance.dao.TicketRepository;
import com.geniusee.cinema.persistance.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.jpa.domain.Specification.where;

@RestController
public class TicketController {
    private final TicketRepository repository;

    public TicketController(TicketRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/tickets")
    Page<Ticket> all(@PageableDefault(page = 0, size = 20)
                            Pageable pageable) {
        return repository.findAll(pageable);
    }

}
