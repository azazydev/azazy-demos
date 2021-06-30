package com.example.paginationdemo.dto;

import lombok.Data;

@Data
public class PaginationDto {
    private Integer totalPages;
    private Integer itemCount;
    private Integer currentPage;
    private Integer pageSize;
}
