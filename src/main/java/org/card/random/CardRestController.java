package org.card.random;

import org.card.random.dao.CardDao;
import org.card.random.dao.DaoService;
import org.card.random.dao.DaoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/random")
public class CardRestController {

    private DaoService daoService = new DaoServiceImpl();

    @RequestMapping(value = "/deck", method = RequestMethod.GET)
    public List<CardDao> getRandomizedDeck() {
        return daoService.getAll();
    }

}
