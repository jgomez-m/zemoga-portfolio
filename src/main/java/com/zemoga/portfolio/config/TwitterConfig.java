package com.zemoga.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.inject.Inject;
import java.util.Objects;

@Configuration
@PropertySource("classpath:twitter.properties")
public class TwitterConfig {

    @Inject
    private Environment environment;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new TwitterConnectionFactory(
                Objects.requireNonNull(environment.getProperty("twitter.consumerKey")),
                Objects.requireNonNull(environment.getProperty("twitter.consumerSecret"))));
        return registry;
    }

    @Bean
    public Twitter twitterConnection() {
        return new TwitterTemplate(
                Objects.requireNonNull(environment.getProperty("twitter.consumerKey")),
                Objects.requireNonNull(environment.getProperty("twitter.consumerSecret")),
                Objects.requireNonNull(environment.getProperty("twitter.accessToken")),
                Objects.requireNonNull(environment.getProperty("twitter.accessTokenSecret")));
    }

}