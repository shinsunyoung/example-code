package me.shinsunyoung.springtest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.shinsunyoung.springtest.vo.Info;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@RunWith(SpringRunner.class)
@WebMvcTest(BlogController.class)
public class BlogControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext ctx;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
        .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 한글 깨짐 처리
        .build();
  }

  @Test
  public void 테스트_GET() throws Exception {

    MultiValueMap<String, String> info = new LinkedMultiValueMap<>();

    info.add("name", "칩");
    info.add("id", "chip");

    mockMvc.perform(get("/blog")       // 1, 2
        .params(info))              // 3
        .andExpect(status().isOk())     // 4
        .andExpect(content().string("칩의 블로그입니다. chip"))
        .andDo(print());                // 5
  }


  @Test
  public void 테스트_POST() throws Exception {

    String content = objectMapper.writeValueAsString(new Info("데일", "dale"));

    mockMvc.perform(post("/blog")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string("데일의 블로그입니다. dale"))
        .andDo(print());
  }
}