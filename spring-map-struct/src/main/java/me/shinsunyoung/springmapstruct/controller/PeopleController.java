package me.shinsunyoung.springmapstruct.controller;

import me.shinsunyoung.springmapstruct.service.PeopleService;
import me.shinsunyoung.springmapstruct.service.dto.PeopleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeopleController {

  @Autowired
  PeopleService peopleService;

  @GetMapping("/")
  public String getPeople() {
    return "hello";
  }

  @PostMapping("/")
  @ResponseBody
  public String postPeople(@ModelAttribute PeopleDTO peopleDTO) {

    peopleService.save(peopleDTO);

    return "success";

  }

}
