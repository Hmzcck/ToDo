package com.hamzacicek.todoapplication;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
class TodoApplicationTest {

    @Test
    void contextLoads() {
        log.info("Application context loaded successfully.");
    }
}
