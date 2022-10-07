package com.geniusee.cinema.dto;

import java.time.LocalDate;
import java.util.Objects;

public class TicketDto {
    private Long id;
    private Long movieId;
    private Integer rowNumber;
    private Integer placeNumber;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(id, ticketDto.id) &&
                Objects.equals(movieId, ticketDto.movieId) &&
                Objects.equals(rowNumber, ticketDto.rowNumber) &&
                Objects.equals(placeNumber, ticketDto.placeNumber) &&
                Objects.equals(date, ticketDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, rowNumber, placeNumber, date);
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", rowNumber=" + rowNumber +
                ", placeNumber=" + placeNumber +
                ", date=" + date +
                '}';
    }
}
