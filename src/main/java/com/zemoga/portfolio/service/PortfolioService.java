package com.zemoga.portfolio.service;

import com.zemoga.portfolio.entity.Portfolio;

import java.util.List;

public interface PortfolioService {

    List<Portfolio> getPortfolios();

    Portfolio getById(Long id);

    Portfolio getByUserName(String userName);

    void update(Portfolio portfolio);
}
