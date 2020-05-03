package com.zemoga.portfolio.api;

import com.zemoga.portfolio.entity.Portfolio;
import com.zemoga.portfolio.exception.UserNotFoundException;
import com.zemoga.portfolio.resource.PortfolioResource;
import com.zemoga.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PortfolioRestController {

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PortfolioResource> getUserInfoById(@PathVariable Long id) {
        Portfolio portfolio = Optional.ofNullable(portfolioService.getById(id))
                .orElseThrow(() -> new UserNotFoundException(id));

        PortfolioResource portfolioResource = new PortfolioResource(portfolio);
        return ResponseEntity.ok(portfolioResource);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUser(@RequestBody Portfolio portfolioFromRequest, @PathVariable Long id) {
        Portfolio portfolio = Optional.ofNullable(portfolioService.getById(id))
                .orElseThrow(() -> new UserNotFoundException(id));

        Optional.ofNullable(portfolioFromRequest.getTwitterUserName())
                .ifPresent(portfolio::setTwitterUserName);
        Optional.ofNullable(portfolioFromRequest.getImageUrl())
                .ifPresent(portfolio::setImageUrl);
        Optional.ofNullable(portfolioFromRequest.getDescription())
                .ifPresent(portfolio::setDescription);
        portfolioService.update(portfolio);
        return ResponseEntity.ok(portfolio);
    }

}