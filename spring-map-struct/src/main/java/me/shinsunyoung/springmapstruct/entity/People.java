package me.shinsunyoung.springmapstruct.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class People {

  /**
   * 유저의 아이디 (PK)
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
