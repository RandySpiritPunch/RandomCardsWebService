package org.card.random.dao;


import java.util.ArrayList;
import java.util.List;

public class DaoServiceImpl implements DaoService {

    List<CardDao> cardDeck = new ArrayList<CardDao>();

    @Override
    public List<CardDao> getAll() {

        createCard("ACE", "SPADE", "master deck");
        createCard("JOKE", "SPADE", "master deck");
        createCard("KING", "SPADE", "master deck");

        return cardDeck;
    }

    private void createCard(String cardType, String cardSuit, String deckType) {
        cardDeck.add(new CardDao(cardType,cardSuit,deckType));
    }
}
