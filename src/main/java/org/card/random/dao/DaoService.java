package org.card.random.dao;


import java.util.List;

public interface DaoService {
    public List<CardDao> getAll();

    public List<CardDao> getCardsBySuit(String suit);
}
