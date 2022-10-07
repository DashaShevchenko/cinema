package com.geniusee.cinema.persistance.dao;

import com.geniusee.cinema.persistance.entity.Movie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieSpecification implements Specification<Movie> {
    private List<SearchCriteria> criteria;

    public MovieSpecification(final List<SearchCriteria> criteria) {
        super();
        this.criteria = criteria;
    }

    public List<SearchCriteria> getCriteria() {
        return criteria;
    }

    @Override
    public Predicate toPredicate(final Root<Movie> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
        Predicate predicate = builder.conjunction();
        MovieSearchQueryCriteriaConsumer searchConsumer = new MovieSearchQueryCriteriaConsumer(predicate, builder, root);
        criteria.forEach(searchConsumer);
        return searchConsumer.getPredicate();
        }
    }
