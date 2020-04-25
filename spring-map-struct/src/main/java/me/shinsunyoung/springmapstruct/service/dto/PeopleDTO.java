package me.shinsunyoung.springmapstruct.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleDTO {

  /**
   * 유저의 아이디 (PK)
   */
  private Long id;

  /**
   * 유저의 이름
   */
  private String name;

  /**
   * 유저의 나이
   */
  private String age;

}
