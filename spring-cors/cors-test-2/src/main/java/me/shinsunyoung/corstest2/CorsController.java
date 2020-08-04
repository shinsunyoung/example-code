package me.shinsunyoung.corstest2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CorsController {

  @GetMapping("/api/view")
  public String view() {
    return "/cors";
  }

  @GetMapping("/api/proxy")
  @ResponseBody
  public String proxy() {
    String url = "http://localhost:1000/hello";

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, String.class);
  }
}
