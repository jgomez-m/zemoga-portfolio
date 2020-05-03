package com.zemoga.portfolio.resource;

import com.zemoga.portfolio.entity.Portfolio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioResource {

    private Long idPortfolio;
    private String imageUrl;
    private String title;
    private String description;
    private String twitterUserName;

    public PortfolioResource(){
        super();
    }

    public PortfolioResource(Long id, String imageUrl, String title, String description, String twitterUserName) {
        this.idPortfolio = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.twitterUserName = twitterUserName;
    }

    public PortfolioResource(Portfolio entity){
        this.idPortfolio = entity.getId();
        this.imageUrl = entity.getImageUrl();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.twitterUserName = entity.getTwitterUserName();
    }
}
