package org.card.random.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoServiceImpl implements DaoService {

    private List<CardDao> cardDeck;

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
        List<CardDao> sameSuitCards = addSameSuitTypesToList(suit);
        return sameSuitCards;
    }

    private List<CardDao> addSameSuitTypesToList(String suit) {
        return getAll().stream().filter(c -> suit.equalsIgnoreCase(c.getCardSuit())).collect(Collectors.toList());
    }

    private void createCard(String cardType, String cardSuit, String deckType) {
        if (cardDeck == null || cardDeck.isEmpty()) {
            cardDeck = new ArrayList<>();
        }
        cardDeck.add(new CardDao(cardType, cardSuit, deckType));
    }
}
