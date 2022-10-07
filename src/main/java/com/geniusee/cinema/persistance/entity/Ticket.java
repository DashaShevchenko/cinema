package com.geniusee.cinema.persistance.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Ticket {
    @Column(name = "id")
    private @Id @GeneratedValue Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "rowNumber")
    private Integer rowNumber;
    @Column(name = "placeNumber")
    private Integer placeNumber;
    @Column(name = "date")
    private LocalDate date;

    public Ticket() {

    }

    public Ticket(Movie movie, Integer rowNumber, Integer placeNumber, LocalDate date) {
        this.movie = movie;
        this.rowNumber = rowNumber;
        this.placeNumber = placeNumber;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket that = (Ticket) o;
        return id.equals(that.id) &&
                Objects.equals(movie, that.movie) &&
                Objects.equals(rowNumber, that.rowNumber) &&
                Objects.equals(placeNumber, that.placeNumber) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, rowNumber, placeNumber, date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
}
