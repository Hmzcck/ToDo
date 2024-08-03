package com.hamzacicek.todoapplication.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITaskController<D> {

    ResponseEntity<D> createTask(D taskDto);

    ResponseEntity<List<D>> getAllTasks();

    ResponseEntity<D> getTaskById(Long id);

    ResponseEntity<D> updateTaskById(Long id, D taskDto);

    ResponseEntity<D> deleteTaskById(Long id);

    ResponseEntity<String> seedData(Integer count);

    ResponseEntity<String> deleteAllTasks();
}
