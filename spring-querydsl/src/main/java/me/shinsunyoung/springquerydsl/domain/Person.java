package me.shinsunyoung.springquerydsl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
public class Person {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable=false)
  private String firstName;

  @Column(nullable=false)
  private String lastName;

  @Column(nullable=false)
  private Integer age;

  @Column(unique=true)
  private String email;

  public Person(String firstName, String lastName, int age, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.email = email;
  }

  public Person() {
  }
}