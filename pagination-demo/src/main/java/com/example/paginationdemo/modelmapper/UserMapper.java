package com.example.paginationdemo.modelmapper;

import com.example.paginationdemo.dto.UserDto;
import com.example.paginationdemo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toUserDto(User user);

    List<UserDto> toUserDto(List<User> users);

    User toUser(UserDto userDto);

    List<User> toUser(List<UserDto> userDtos);
}
