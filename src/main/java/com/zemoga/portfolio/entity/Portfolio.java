package com.zemoga.portfolio.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="portfolio")
@Data
public class Portfolio {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idportfolio")
    private Long id;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="twitter_user_name")
    private String twitterUserName;

    public Portfolio(){

    }
}
