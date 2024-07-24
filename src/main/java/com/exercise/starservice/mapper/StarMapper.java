package com.exercise.starservice.mapper;

import com.exercise.starservice.dto.StarDto;
import com.exercise.starservice.model.Star;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StarMapper {

    StarMapper INSTANCE = Mappers.getMapper(StarMapper.class);

    StarDto toDto(Star star);

    Star toEntity(StarDto starDto);
}
