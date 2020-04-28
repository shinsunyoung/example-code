package me.shinsunyoung.springquerydsl.repository;

import me.shinsunyoung.springquerydsl.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PersonRepository extends JpaRepository<Person, Integer>,
    QuerydslPredicateExecutor<Person> {

}
