package com.hamzacicek.todoapplication.business.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamzacicek.todoapplication.bean.ModelMapperBean;
import com.hamzacicek.todoapplication.business.dto.TaskDto;
import com.hamzacicek.todoapplication.business.services.ITaskService;
import com.hamzacicek.todoapplication.data.entity.TaskEntity;
import com.hamzacicek.todoapplication.data.repository.TaskRepository;
import com.hamzacicek.todoapplication.exception.NotFound404Exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICE
@Service
public class TaskServiceImpl implements ITaskService<TaskDto, TaskEntity> {

    private final TaskRepository taskRepository;
    private final ModelMapperBean modelMapperBean;

    @Override
    public TaskDto entityToDto(TaskEntity taskEntity) {
        return modelMapperBean.getModelMapper().map(taskEntity, TaskDto.class);
    }

    @Override
    public TaskEntity dtoToEntity(TaskDto taskDto) {
        return modelMapperBean.getModelMapper().map(taskDto, TaskEntity.class);
    }

    @Override
    @Transactional
    public String seedData(Integer count) {
        if (count != null) {
            for (int i = 1; i <= count; i++) {
                TaskEntity taskEntity = TaskEntity.builder()
                        .title("title" + i)
                        .description("Description for title" + i)
                        .status(0L)
                        .dueDate(LocalDate.now().plusDays(i))
                        .build();
                taskRepository.save(taskEntity);
            }
        } else {
            throw new NullPointerException("Count cannot be null");
        }
        log.info("{} new data seeded.", count);
        return count + " new data seeded.";
    }

    @Override
    @Transactional
    public String deleteAll() {
        taskRepository.deleteAll();
        log.info("Deleted all records successfully.");
        return "Deleted all records successfully.";
    }

    @Override
    public List<TaskDto> listAll() {
        Iterable<TaskEntity> entityIterable = taskRepository.findAll();
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (TaskEntity entity : entityIterable) {
            TaskDto taskDto = entityToDto(entity);
            taskDtoList.add(taskDto);
        }
        log.info("Task count: {}", taskDtoList.size());
        return taskDtoList;
    }

    @Override
    @Transactional
    public TaskDto save(TaskDto taskDto) {
        if (taskDto != null) {
            TaskEntity taskEntity = dtoToEntity(taskDto);
            taskRepository.save(taskEntity);
            taskDto.setId(taskEntity.getId());
            taskDto.setCreatedAt(taskEntity.getCreatedAt());
            if(taskEntity.getDueDate() == null) {
                taskDto.setDueDate(LocalDate.now());
            }
            log.info("Task saved with title: {}", taskDto.getTitle());
        } else {
            throw new NullPointerException("Task is null.");
        }
        return taskDto;
    }

    @Override
    public TaskDto findById(Long id) {
        Optional<TaskEntity> findOptionalTaskEntity = taskRepository.findById(id);
        if (findOptionalTaskEntity.isPresent()) {
            return entityToDto(findOptionalTaskEntity.get());
        } else {
            log.error("Task not found with id: {}", id);
            throw new NotFound404Exception("Task not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public TaskDto updateById(Long id, TaskDto taskDto) {
        TaskDto taskDtoToFind = findById(id);
        if (taskDtoToFind != null) {
            TaskEntity taskEntity = dtoToEntity(taskDtoToFind);
            taskEntity.setTitle(taskDto.getTitle());
            taskEntity.setDescription(taskDto.getDescription());
            taskEntity.setStatus(taskDto.getStatus());
            taskEntity.setDueDate(taskDto.getDueDate());
            taskRepository.save(taskEntity);
            log.info("Task updated with id: {}", id);
            return entityToDto(taskEntity);
        } else {
            log.error("Task not found with id: {}", id);
            throw new NotFound404Exception("Task not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public TaskDto deleteById(Long id) {
        TaskDto taskDtoToFind = findById(id);
        if (taskDtoToFind != null) {
            taskRepository.deleteById(id);
            log.info("Task deleted with id: {}", id);
        } else {
            log.error("Task not found with id: {}", id);
            throw new NotFound404Exception("Task not found with id: " + id);
        }
        return taskDtoToFind;
    }
}
