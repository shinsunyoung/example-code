package me.shinsunyoung.springrestdocs;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

  @Rule
  public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

  private MockMvc mockMvc;

  @Autowired
  WebApplicationContext context;


  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(this.restDocumentation))
        .build();
  }

  @Test
  public void Hello_테스트() throws Exception {

    // given
    String name = "칩앤데일";

    // when
    mockMvc.perform(get("/hello/" + name)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())  // then
        .andExpect(jsonPath("$.name").value(name))
        .andDo(document("hello"));
  }

}