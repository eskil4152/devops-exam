package no.kristiania.devopsexam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DevopsExamApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void fail() {
        assertEquals(3, 3);
    }
}
