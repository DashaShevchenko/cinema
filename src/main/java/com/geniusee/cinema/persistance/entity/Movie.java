package com.geniusee.cinema.persistance.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Movie {
    @Column(name = "id")
    private @Id @GeneratedValue
    Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;

    public Movie() {}

    public Movie(String name, Integer duration) {

        this.name = name;
        this.duration = duration;
    }

    public Movie(Long id) {

        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name) &&
                Objects.equals(duration, movie.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
