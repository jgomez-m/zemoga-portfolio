package com.zemoga.portfolio.controller;

import com.zemoga.portfolio.entity.Portfolio;
import com.zemoga.portfolio.exception.UserNotFoundException;
import com.zemoga.portfolio.model.UserPortfolioDTO;
import com.zemoga.portfolio.service.PortfolioService;
import com.zemoga.portfolio.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private TwitterService twitterService;

    @RequestMapping(value = "/portfolios/{userName}", method = RequestMethod.GET)
    public ModelAndView getPortfolio(@PathVariable String userName) {
        Portfolio portfolio = Optional.ofNullable(this.portfolioService.getByUserName(userName))
                .orElseThrow(() -> new UserNotFoundException(userName));
        List<Tweet> tweets = twitterService.getTweets(userName);
        return new ModelAndView("portfolio", "userPortfolio", new UserPortfolioDTO(portfolio, tweets));
    }
}
