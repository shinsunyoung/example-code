package me.shinsunyoung.springvalidation.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.shinsunyoung.springvalidation.dto.Obj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ValidController.class)
public class ValidControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;


  @Test
  public void validation_실패() throws Exception {
    String content = objectMapper.writeValueAsString(new Obj("냠냠이", null));

    mockMvc.perform(post("/valid")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.message").value("유효성 검사 실패 : 나이"))
        .andDo(print());
  }

  @Test
  public void validation_성공() throws Exception {
    String content = objectMapper.writeValueAsString(new Obj("냠냠이", 10));

    mockMvc.perform(post("/valid")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print());
  }


  @Test
  public void 핸드폰번호_validation_성공() throws Exception {
    String content = objectMapper.writeValueAsString(new Obj("냠냠이", 10, "01012345678"));

    mockMvc.perform(post("/valid")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print());
  }


  @Test
  public void 핸드폰번호_validation_실패() throws Exception {
    String content = objectMapper.writeValueAsString(new Obj("냠냠이", 10, "123456789123"));

    mockMvc.perform(post("/valid")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.message").value("유효성 검사 실패 : 휴대폰 번호"))
        .andDo(print());
  }


}