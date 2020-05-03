package com.zemoga.portfolio.service;

import com.zemoga.portfolio.entity.Portfolio;
import com.zemoga.portfolio.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultPortfolioService implements  PortfolioService {


    private PortfolioRepository portfolioRepository;

    public DefaultPortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public List<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public Portfolio getById(Long id) {
        Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(id);
        return optionalPortfolio.orElse(null);
    }

    @Override
    public Portfolio getByUserName(String userName) {
        return portfolioRepository.findByTwitterUserName(userName)
                .stream()
                .findFirst()
                .get();
    }

    @Override
    public void update(Portfolio portfolio) {
        portfolioRepository.update(portfolio);
    }

}
