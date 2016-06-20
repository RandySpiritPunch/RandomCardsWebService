package org.card.random.dao;


public class CardDao {

    private String cardType;

    private String cardSuit;

    private String deckType;

    public CardDao() {
    }

    public CardDao(String cardType, String cardSuit, String deckType) {
        this.cardType = cardType;
        this.cardSuit = cardSuit;
        this.deckType = deckType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public String getDeckType() {
        return deckType;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }
}
