package com.hamzacicek.todoapplication.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hamzacicek.todoapplication.business.dto.TaskDto;
import com.hamzacicek.todoapplication.business.services.ITaskService;
import com.hamzacicek.todoapplication.controller.ITaskController;
import com.hamzacicek.todoapplication.data.entity.TaskEntity;
import com.hamzacicek.todoapplication.exception.NotFound404Exception;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// CONTROLLER
@RestController
@CrossOrigin()
@RequestMapping("/task/api/v1")
public class TaskControllerImpl implements ITaskController<TaskDto> {

    private final ITaskService<TaskDto, TaskEntity> taskService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskDto));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.listAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(taskService.findById(id));
        } catch (NotFound404Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTaskById(@PathVariable(name = "id") Long id, @Valid @RequestBody TaskDto taskDto) {
        try {
            return ResponseEntity.ok(taskService.updateById(id, taskDto));
        } catch (NotFound404Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> deleteTaskById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(taskService.deleteById(id));
        } catch (NotFound404Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @PostMapping("/seed/{count}")
    public ResponseEntity<String> seedData(@PathVariable(name = "count") Integer count) {
        return ResponseEntity.ok(taskService.seedData(count));
    }

    @Override
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllTasks() {
        return ResponseEntity.ok(taskService.deleteAll());
    }
}
