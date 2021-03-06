package org.card.random;

import org.card.random.dao.CardDao;
import org.card.random.dao.DaoService;
import org.card.random.dao.DaoServiceImpl;
import org.springframework.web.bind.annotation.*;

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
    public List<CardDao> getCardsBySuit(@RequestBody String c) {
        DaoService daoService = new DaoServiceImpl();
        return daoService.getCardsBySuit(c);
    }
}
