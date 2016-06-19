package org.card.random.dao;


import java.util.ArrayList;
import java.util.List;

public class DaoServiceImpl implements DaoService {

    List<CardDao> cardDeck;

    @Override
    public List<CardDao> getAll() {

        createCard("ACE", "SPADE", "master deck");
        createCard("JOKE", "CLOVE", "master deck");
        createCard("KING", "HEART", "master deck");
        createCard("QUEEN", "HEART", "master deck");

        return cardDeck;
    }

    @Override
    public List<CardDao> getCardsBySuit(String suit) {
        List<CardDao> sameSuitCards = new ArrayList<CardDao>();
        for (CardDao c : getAll()) {
            if (suit.equalsIgnoreCase(c.getCardSuit())) {
                sameSuitCards.add(c);
            }
        }
        return sameSuitCards;
    }

    private void createCard(String cardType, String cardSuit, String deckType) {
        if (cardDeck == null || cardDeck.isEmpty()) {
            cardDeck = new ArrayList<CardDao>();
        }
        cardDeck.add(new CardDao(cardType, cardSuit, deckType));
    }
}
