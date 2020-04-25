package me.shinsunyoung.springmapstruct.mapper;

import me.shinsunyoung.springmapstruct.entity.People;
import me.shinsunyoung.springmapstruct.service.dto.PeopleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeopleMapper extends EntityMapper<PeopleDTO, People> {

}
