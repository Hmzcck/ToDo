package com.hamzacicek.todoapplication.Task;

import com.hamzacicek.todoapplication.business.dto.TaskDto;
import com.hamzacicek.todoapplication.exception.NotFound404Exception;

public interface ITaskServiceTest {

    public void testSeedData();

    public void testFindById();

    public void testFindByIdNotFound();

    public void testSave();

    public void testUpdateById();

    public void testUpdateByIdNotFound();

    public void testDeleteById();

    public void testDeleteByIdNotFound();

    public void testListAll();

    public void testDeleteAll();
}
