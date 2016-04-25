package com.cheng.test;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Desc: 消费者
 * Author: Cheng
 * Date: 2016/4/22 0022
 */
public class Foo  implements MessageListener {
    // 具体的执行业务
    public void listen(Object foo) {
        System.out.println("消费者===> "+foo);
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("data ==> "+new String(message.getBody()));
    }
}
