package com.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend("queue","hello,rabbit~");
    }
    //Topic模式
    void send2(){
        template.convertAndSend("exchange","topic.message","hello,rabbit~~~11");
        template.convertAndSend("exchange","topic.messages","hello,rabbit~~~22");
    }

    public void send3(int number) {
        System.out.println("DeadLetterSender : " + number);
        // 这里的Exchange可以是业务的Exchange，为了方便测试这里直接往死信Exchange里投递消息
        template.convertAndSend(
                RabbitDeadLetterConfig.DEAD_LETTER_EXCHANGE,
                RabbitDeadLetterConfig.DEAD_LETTER_TEST_ROUTING_KEY,
                number);
    }
}
