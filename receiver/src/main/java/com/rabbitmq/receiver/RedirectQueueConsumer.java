package com.rabbitmq.receiver;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = RabbitDeadLetterConfig.REDIRECT_QUEUE)
@Component
public class RedirectQueueConsumer {

    /**
     * 重定向队列和死信队列形参一致Integer number
     * @param number
     */
    @RabbitHandler
    public void fromDeadLetter(Integer number){
        System.out.println("RedirectQueueConsumer : {}" + number);
        // 对应的操作
        int i = number / 1;
    }
}
