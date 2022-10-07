package com.geniusee.cinema.converter;

import com.geniusee.cinema.dto.MovieDto;
import com.geniusee.cinema.dto.TicketDto;
import com.geniusee.cinema.persistance.entity.Movie;
import com.geniusee.cinema.persistance.entity.Ticket;

public class TicketConverter extends DtoConverter<Ticket, TicketDto> {
    @Override
    public TicketDto toDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setPlaceNumber(ticket.getPlaceNumber());
        ticketDto.setRowNumber(ticket.getRowNumber());
        ticketDto.setDate(ticket.getDate());
        ticketDto.setMovieId(ticket.getMovie().getId());
        return ticketDto;
    }

    @Override
    public Ticket fromDto(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setMovie(new Movie(ticketDto.getId()));
        ticket.setPlaceNumber(ticketDto.getPlaceNumber());
        ticket.setRowNumber(ticketDto.getRowNumber());
        return  ticket;

    }
}
