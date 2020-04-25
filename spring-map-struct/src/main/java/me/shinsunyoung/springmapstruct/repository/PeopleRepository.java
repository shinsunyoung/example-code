package me.shinsunyoung.springmapstruct.repository;


import me.shinsunyoung.springmapstruct.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {


}
