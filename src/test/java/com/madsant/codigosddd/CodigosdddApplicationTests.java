package com.madsant.codigosddd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodigosdddApplicationTests {

    @Test
    void contextLoads() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture(
            "message"
        );
        assertTrue(cf.isDone());
        assertEquals("message", cf.getNow(null));
    }
}
