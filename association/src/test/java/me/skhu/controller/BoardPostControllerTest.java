package me.skhu.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Manki Kim on 2017-01-23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class BoardPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBoardPost() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/v1/boardpost/create")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"title\":\"모임공지1\"," +
                        "\"content\":\"수요일 1시 미가엘관\"," +
                        "\"writer_id\":\"3\"," +
                        "\"writer_name\":\"김만기\"," +
                        "\"ownBoardId\":\"1\"" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
        log.debug("{}", result.getResponse().getContentAsString());

    }


}
