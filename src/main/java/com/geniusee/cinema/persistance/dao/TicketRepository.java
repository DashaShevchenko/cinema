package com.geniusee.cinema.persistance.dao;

import com.geniusee.cinema.persistance.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {

    @Query("select c from Ticket c")
    Page<Ticket> findAllPage(Specification<Ticket> spec, Pageable pageable);
}
