package me.shinsunyoung.springquerydsl.predicate;

import com.querydsl.core.BooleanBuilder;

import com.querydsl.core.types.Predicate;
import me.shinsunyoung.springquerydsl.domain.QPerson;

public class PersonPredicate {


  public static Predicate search(String firstName, String lastName){
    QPerson person = QPerson.person;

    BooleanBuilder builder = new BooleanBuilder();

    if(firstName != null){
      builder.and(person.firstName.eq(firstName));
    }
    if(lastName != null){
      builder.and(person.lastName.eq(lastName));
    }
    return builder;
  }

}
