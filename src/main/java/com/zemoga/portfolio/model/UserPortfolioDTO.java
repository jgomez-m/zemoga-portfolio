package com.zemoga.portfolio.model;

import com.zemoga.portfolio.entity.Portfolio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.social.twitter.api.Tweet;

import java.util.List;

@Getter
@Setter
public class UserPortfolioDTO {
    private Portfolio portfolio;
    private List<Tweet> tweets;

    public UserPortfolioDTO(Portfolio portfolio, List<Tweet> tweets) {
        this.portfolio = portfolio;
        this.tweets = tweets;
    }
}
