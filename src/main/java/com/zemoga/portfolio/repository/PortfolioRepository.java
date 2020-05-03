package com.zemoga.portfolio.repository;

import com.zemoga.portfolio.entity.Portfolio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {

    List<Portfolio> findAll();

    Optional<Portfolio> findById(Long id);

    List<Portfolio> findByTwitterUserName(String userName);

    default void update(Portfolio portfolio){
        this.save(portfolio);
    }
}