package com.example.demo.service.impl;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentServiceImpl(DepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public DepartmentDto create(DepartmentDto dto) {
        Department entity = new Department();
        BeanUtils.copyProperties(dto, entity);
        Department saved = repo.save(entity);
        DepartmentDto out = new DepartmentDto();
        BeanUtils.copyProperties(saved, out);
        return out;
    }

    @Override
    public DepartmentDto getById(Long id) {
        Department d = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        DepartmentDto out = new DepartmentDto();
        BeanUtils.copyProperties(d, out);
        return out;
    }

    @Override
    public List<DepartmentDto> listAll() {
        return repo.findAll().stream().map(d -> {
            DepartmentDto dto = new DepartmentDto();
            BeanUtils.copyProperties(d, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto update(Long id, DepartmentDto dto) {
        Department d = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        d.setName(dto.getName());
        d.setDescription(dto.getDescription());
        Department saved = repo.save(d);
        DepartmentDto out = new DepartmentDto();
        BeanUtils.copyProperties(saved, out);
        return out;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
