package com.rabbitmq.sender;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitMQTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    void testRabbit() {
        helloSender.send();
    }

    @Test
    void testRabbit2() {
        helloSender.send2();
    }

    @Test
    void testRabbit3() {
        helloSender.send3(15);
    }
}
