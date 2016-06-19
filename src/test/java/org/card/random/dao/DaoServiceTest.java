package org.card.random.dao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DaoServiceTest {


    @Test
    public void getAllCards() throws Exception {
        DaoService daoService = new DaoServiceImpl();

        assertEquals(4,daoService.getAll().size());
    }

    @Test
    public void getAllCardsWithSameSuit() throws Exception {
        DaoService daoService = new DaoServiceImpl();

        assertEquals(2, daoService.getCardsBySuit("HEART").size());
    }
}