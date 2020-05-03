package com.zemoga.portfolio.controller;

import com.zemoga.portfolio.entity.Portfolio;
import com.zemoga.portfolio.exception.UserNotFoundException;
import com.zemoga.portfolio.service.PortfolioService;
import com.zemoga.portfolio.service.TwitterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PortfolioControllerTest {

    @Mock
    private PortfolioService portfolioService;
    @Mock
    private TwitterService twitterService;
    @InjectMocks
    private PortfolioController controller;

    private static final String USER_NAME = "user1234";
    private static final String USER_NOT_FOUND = "not found";

    @Before
    public void setUp() throws Exception {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(1L);
        portfolio.setTitle("Portfolio Title");
        when(portfolioService.getByUserName(any())).thenReturn(portfolio);
        when(twitterService.getTweets(any())).thenReturn(new ArrayList<Tweet>());
    }

    @Test
    public void testGetPortfolio() throws Exception {
        ModelAndView response = controller.getPortfolio(USER_NAME);
        verify(portfolioService).getByUserName(USER_NAME);
        verify(twitterService).getTweets(USER_NAME);

        assertNotNull(response);
        assertNotNull(portfolioService.getByUserName(USER_NAME));
        assertNotNull(twitterService.getTweets(USER_NAME));
    }

    @Test(expected = UserNotFoundException.class)
    public final void testUserNotFoundException() throws Exception {
        when(portfolioService.getByUserName(USER_NOT_FOUND)).thenReturn(null);
        controller.getPortfolio(USER_NOT_FOUND);
    }

}
