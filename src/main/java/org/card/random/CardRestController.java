package org.card.random;

import org.card.random.dao.CardDao;
import org.card.random.dao.DaoService;
import org.card.random.dao.DaoServiceImpl;
import org.card.random.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/random")
public class CardRestController {


    @RequestMapping(value = "/deck", method = RequestMethod.GET)
    public List<CardDao> getRandomizedDeck() {
        DaoService daoService = new DaoServiceImpl();
        return daoService.getAll();
    }

    @RequestMapping(value = "/deck/suit", method = RequestMethod.GET)
    public List<CardDao> getCardsBySuit(@RequestBody CardDao c) throws ResourceNotFoundException {
        DaoService daoService = new DaoServiceImpl();
        List<CardDao> cards = daoService.getCardsBySuit(c.getCardSuit());

        if(cards.isEmpty()){
            System.out.println(cards.isEmpty());
            throw new ResourceNotFoundException(c.getCardSuit());
        }
        return cards;
    }

}
