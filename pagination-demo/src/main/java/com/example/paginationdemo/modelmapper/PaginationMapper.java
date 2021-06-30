package com.example.paginationdemo.modelmapper;

import com.example.paginationdemo.dto.PaginationDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PaginationMapper {

    public PaginationDto toPaginationDto(Page page) {
        PaginationDto paginationDto = new PaginationDto();
        paginationDto.setCurrentPage(page.getNumber());
        paginationDto.setItemCount(page.getNumberOfElements());
        paginationDto.setPageSize(page.getSize());
        paginationDto.setTotalPages(page.getTotalPages());
        return paginationDto;
    }

}
