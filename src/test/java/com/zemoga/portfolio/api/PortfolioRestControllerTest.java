package com.zemoga.portfolio.api;

import com.zemoga.portfolio.entity.Portfolio;
import com.zemoga.portfolio.exception.UserNotFoundException;
import com.zemoga.portfolio.resource.PortfolioResource;
import com.zemoga.portfolio.service.PortfolioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PortfolioRestControllerTest {

    @Mock
    private PortfolioService portfolioService;
    @InjectMocks
    private PortfolioRestController controller;

    private Portfolio portfolio = new Portfolio();

    private static final String USER_NAME = "user1234";

    @Before
    public void setUp() throws Exception {
        portfolio.setId(1L);
        portfolio.setTitle("Portfolio Title");
        when(portfolioService.getById(1L)).thenReturn(portfolio);
        when(portfolioService.getById(2L)).thenReturn(null);
        when(portfolioService.getPortfolios()).thenReturn(new ArrayList<>());
    }

    @Test
    public void testGetPortfolio() throws Exception {
        ResponseEntity<PortfolioResource> response = controller.getUserInfoById(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(response.getBody().getIdPortfolio(), portfolio.getId());
        assertEquals(response.getBody().getTitle(), portfolio.getTitle());

        verify(portfolioService).getById(anyLong());
    }

    @Test(expected = UserNotFoundException.class)
    public void testGetPortfolioUserNotFound() throws Exception {
        controller.getUserInfoById(2L);
    }

}