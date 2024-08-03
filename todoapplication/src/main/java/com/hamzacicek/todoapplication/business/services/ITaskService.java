package com.hamzacicek.todoapplication.business.services;

import java.util.List;

import com.hamzacicek.todoapplication.business.dto.TaskDto;

// D: Dto
// E: Entity
public interface ITaskService<D, E> {

    // Model Mapping
    public D entityToDto(E entity);

    public E dtoToEntity(D dto);

    // Data Seeding
    public String seedData(Integer count);

    // Delete All
    public String deleteAll();

    // List All
    public List<D> listAll();

    // CRUD

    // Create
    public D save(D dto);

    // Read
    public D findById(Long id);

    // Update
    public D updateById(Long id, D dto);

    // Delete
    public TaskDto deleteById(Long id);
}
