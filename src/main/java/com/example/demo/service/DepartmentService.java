package com.example.demo.service;

import com.example.demo.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create(DepartmentDto dto);
    DepartmentDto getById(Long id);
    List<DepartmentDto> listAll();
    DepartmentDto update(Long id, DepartmentDto dto);
    void delete(Long id);
}
