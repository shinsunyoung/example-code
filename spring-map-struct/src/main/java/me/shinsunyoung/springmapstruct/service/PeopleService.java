package me.shinsunyoung.springmapstruct.service;


import me.shinsunyoung.springmapstruct.entity.People;
import me.shinsunyoung.springmapstruct.mapper.PeopleMapper;
import me.shinsunyoung.springmapstruct.repository.PeopleRepository;
import me.shinsunyoung.springmapstruct.service.dto.PeopleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

  @Autowired
  PeopleRepository peopleRepository;

  @Autowired
  PeopleMapper peopleMapper;

  public PeopleService(PeopleMapper peopleMapper) {
    this.peopleMapper = peopleMapper;
  }

  /**
   * 유저 저장
   *
   * @param peopleDTO peopleDTO
   */
  public void save(PeopleDTO peopleDTO) {

    People people = peopleMapper.toEntity(peopleDTO);
    peopleRepository.save(people);

  }

}
