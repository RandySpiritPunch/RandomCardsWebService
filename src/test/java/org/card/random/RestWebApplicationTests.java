package org.card.random;

import org.card.random.dao.CardDao;
import org.card.random.dao.DaoService;
import org.card.random.dao.DaoServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestWebApplication.class)
@WebAppConfiguration
public class RestWebApplicationTests {

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Autowired
    private WebApplicationContext webApplicationContext;


    private DaoService daoService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void testUriNotFound() throws Exception {
        mockMvc.perform(get("/random")).andExpect(status().isNotFound());

    }

    @Test
    public void testSuccessfulGetRequest() throws Exception {
        mockMvc.perform(get("/random/deck"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFirstIndexOfRandomDeck() throws Exception {

        mockMvc.perform(get("/random/deck"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].cardType", is(getDeckFromDaoServer().get(0).getCardType())))
                .andExpect(jsonPath("$[0].deckType", is(getDeckFromDaoServer().get(0).getDeckType())))
                .andExpect(jsonPath("$[0].cardSuit", is(getDeckFromDaoServer().get(0).getCardSuit())));
    }

    @Test
    public void testGetRandomDeck() throws Exception {

        mockMvc.perform(get("/random/deck"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].cardType", is(getDeckFromDaoServer().get(0).getCardType())))
                .andExpect(jsonPath("$[0].deckType", is(getDeckFromDaoServer().get(0).getDeckType())))
                .andExpect(jsonPath("$[0].cardSuit", is(getDeckFromDaoServer().get(0).getCardSuit())))
                .andExpect(jsonPath("$[1].cardType", is(getDeckFromDaoServer().get(1).getCardType())))
                .andExpect(jsonPath("$[1].deckType", is(getDeckFromDaoServer().get(1).getDeckType())))
                .andExpect(jsonPath("$[1].cardSuit", is(getDeckFromDaoServer().get(1).getCardSuit())))
                .andExpect(jsonPath("$[2].cardType", is(getDeckFromDaoServer().get(2).getCardType())))
                .andExpect(jsonPath("$[2].deckType", is(getDeckFromDaoServer().get(2).getDeckType())))
                .andExpect(jsonPath("$[2].cardSuit", is(getDeckFromDaoServer().get(2).getCardSuit())));
    }

    private List<CardDao> getDeckFromDaoServer() {
        if (daoService == null)
            daoService = new DaoServiceImpl();

        return daoService.getAll();
    }

    @Test
    public void getCardsBySuitTypeHeart() throws Exception {

        mockMvc.perform(get("/random/deck/suit").content("HEART"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].cardType", is(getDeckFromDaoServer().get(2).getCardType())))
                .andExpect(jsonPath("$[0].deckType", is(getDeckFromDaoServer().get(2).getDeckType())))
                .andExpect(jsonPath("$[0].cardSuit", is(getDeckFromDaoServer().get(2).getCardSuit())))
                .andExpect(jsonPath("$[1].cardType", is(getDeckFromDaoServer().get(3).getCardType())))
                .andExpect(jsonPath("$[1].deckType", is(getDeckFromDaoServer().get(3).getDeckType())))
                .andExpect(jsonPath("$[1].cardSuit", is(getDeckFromDaoServer().get(3).getCardSuit())));

    }

    @Test
    public void getCardsBySuitTypeSpade() throws Exception {
        mockMvc.perform(get("/random/deck/suit").content("SPADE"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].cardType", is(getDeckFromDaoServer().get(0).getCardType())))
                .andExpect(jsonPath("$[0].deckType", is(getDeckFromDaoServer().get(0).getDeckType())))
                .andExpect(jsonPath("$[0].cardSuit", is(getDeckFromDaoServer().get(0).getCardSuit())));
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }


}