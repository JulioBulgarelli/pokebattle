package br.com.ada.f1rst.pokebattle.controller;

import br.com.ada.f1rst.pokebattle.BaseTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PokeEvolutionsResponseControllerTest extends BaseTestContext {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @BeforeEach
    void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getsEvolutions() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders
                .get("/api/evolutions/{pokemon_name}", "pikachu")
                .accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.forms[*]").isArray());
    }

    @Test
    void throwsNotFound() throws Exception {
        mvc.perform(
            MockMvcRequestBuilders
                .get("/api/evolutions/{pokemon_name}", "asdasdasdas")
                .accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isNotFound());
    }
}
