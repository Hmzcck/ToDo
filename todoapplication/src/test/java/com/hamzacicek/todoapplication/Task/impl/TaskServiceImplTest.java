package com.hamzacicek.todoapplication.Task.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.hamzacicek.todoapplication.Task.ITaskServiceTest;
import com.hamzacicek.todoapplication.business.dto.TaskDto;
import com.hamzacicek.todoapplication.business.services.impl.TaskServiceImpl;
import com.hamzacicek.todoapplication.data.entity.TaskEntity;
import com.hamzacicek.todoapplication.data.repository.TaskRepository;
import com.hamzacicek.todoapplication.exception.NotFound404Exception;

import lombok.extern.log4j.Log4j2;

// LOMBOK
@Log4j2

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceImplTest implements ITaskServiceTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskServiceImpl taskService;

    private TaskEntity taskEntity;
    private TaskDto taskDto;

    @BeforeAll
    static void beforeAll() {
        System.out.println("****** All Tests Starting ******");
        log.info("****** All Tests Starting ******");
    }

    @BeforeEach
    void setUp() {
        taskEntity = new TaskEntity();
        taskDto = new TaskDto();
        System.out.println("****** Starting Test ******");
        log.info("****** Starting Test ******");
    }

    @AfterEach
    void tearDown() {
        taskEntity = null;
        taskDto = null;
        System.out.println("****** Test Finished ******");
        log.info("****** Test Finished ******");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("****** All Tests Finished ******");
        log.info("****** All Tests Finished ******");
    }

    @Override
    @Test
    @Order(1)
    @Transactional
    public void testSeedData() {
        String result = taskService.seedData(5);
        assertEquals("5 new data seeded.", result);
        List<TaskEntity> tasks = (List<TaskEntity>) taskRepository.findAll();
        assertEquals(5, tasks.size());
    }

    @Override
    @Test
    @Order(2)
    @Transactional
    public void testFindById() {
        TaskEntity taskEntity = TaskEntity.builder().title("Task 1").description("Description 1").dueDate(LocalDate.now().plusDays(1)).build();
        taskRepository.save(taskEntity);
        TaskDto taskDto = taskService.findById(taskEntity.getId());
        assertNotNull(taskDto);
        assertEquals(taskEntity.getTitle(), taskDto.getTitle());
    }

    @Override
    @Test
    @Order(3)
    public void testFindByIdNotFound() {
        assertThrows(NotFound404Exception.class, () -> taskService.findById(999L));
    }

    @Override
    @Test
    @Order(4)
    @Transactional
    public void testSave() {
        taskDto.setTitle("New Task");
        taskDto.setDescription("New Description");
        taskDto.setDueDate(LocalDate.now().plusDays(1)); // Set due date
        TaskDto savedTask = taskService.save(taskDto);
        assertNotNull(savedTask);
        assertNotNull(savedTask.getId());
        assertEquals("New Task", savedTask.getTitle());
    }

    @Override
    @Test
    @Order(5)
    @Transactional
    public void testUpdateById() {
        TaskEntity taskEntity = TaskEntity.builder().title("Task 1").description("Description 1").dueDate(LocalDate.now().plusDays(1)).build();
        taskRepository.save(taskEntity);
        taskDto.setTitle("Updated Task");
        taskDto.setDueDate(LocalDate.now().plusDays(2)); // Set due date
        TaskDto updatedTask = taskService.updateById(taskEntity.getId(), taskDto);
        assertNotNull(updatedTask);
        assertEquals("Updated Task", updatedTask.getTitle());
    }

    @Override
    @Test
    @Order(6)
    public void testUpdateByIdNotFound() {
        taskDto.setTitle("Updated Task");
        taskDto.setDueDate(LocalDate.now().plusDays(2)); // Set due date
        assertThrows(NotFound404Exception.class, () -> taskService.updateById(999L, taskDto));
    }

    @Override
    @Test
    @Order(7)
    @Transactional
    public void testDeleteById() {
        TaskEntity taskEntity = TaskEntity.builder().title("Task to delete").description("Description").dueDate(LocalDate.now().plusDays(1)).build();
        taskRepository.save(taskEntity);
        TaskDto deletedTask = taskService.deleteById(taskEntity.getId());
        assertNotNull(deletedTask);
        assertFalse(taskRepository.existsById(taskEntity.getId()));
    }

    @Override
    @Test
    @Order(8)
    public void testDeleteByIdNotFound() {
        assertThrows(NotFound404Exception.class, () -> taskService.deleteById(999L));
    }

    @Override
    @Test
    @Order(9)
    @Transactional
    public void testListAll() {
        taskService.seedData(3);
        List<TaskDto> tasks = taskService.listAll();
        assertNotNull(tasks);
        assertTrue(tasks.size() >= 3);
    }

    @Override
    @Test
    @Order(10)
    @Transactional
    public void testDeleteAll() {
        taskService.seedData(3);
        taskService.deleteAll();
        List<TaskEntity> tasks = (List<TaskEntity>) taskRepository.findAll();
        assertEquals(0, tasks.size());
    }
}
