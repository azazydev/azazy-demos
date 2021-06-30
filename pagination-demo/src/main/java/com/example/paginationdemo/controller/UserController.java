package com.example.paginationdemo.controller;

import com.example.paginationdemo.dto.PaginatedResultDto;
import com.example.paginationdemo.dto.PaginationDto;
import com.example.paginationdemo.dto.UserDto;
import com.example.paginationdemo.model.User;
import com.example.paginationdemo.modelmapper.PaginationMapper;
import com.example.paginationdemo.modelmapper.UserMapper;
import com.example.paginationdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserMapper userMapper;
    private PaginationMapper paginationMapper;

    @GetMapping
    public ResponseEntity<?> getUsers(Pageable pageable) {
        Page<User> userPage = userService.getPaginatedUsers(pageable);
        PaginatedResultDto<UserDto> paginatedResult = new PaginatedResultDto<>();
        List<UserDto> userDtos = userMapper.toUserDto(userPage.getContent());
        paginatedResult.setData(userDtos);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(userPage));
        return ResponseEntity.ok(paginatedResult);
    }
}
