package org.card.random.dao;


import java.util.ArrayList;
import java.util.List;

public class DaoServiceImpl implements DaoService {
    @Override
    public List<CardDao> getAll() {

        CardDao card = new CardDao();
        card.setCardType("ACE");
        card.setCardSuit("SPADE");
        card.setDeckType("master deck");

        List<CardDao> cards = new ArrayList<CardDao>();
        cards.add(card);

        return cards;
    }
}
