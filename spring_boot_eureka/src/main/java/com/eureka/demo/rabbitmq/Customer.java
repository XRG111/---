package com.eureka.demo.rabbitmq;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {
    private static final String QUEUE_NAME = "admin_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println("001");
        // 1.获取连接
        Connection newConnection = MQConnectionUtils.newConnection();
        // 2.获取通道
        Channel channel = newConnection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);// 保证一次只分发一次 限制发送给同一个消费者 不得超过一条消息
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msgString = new String(body, "UTF-8");
                System.out.println("消费者获取消息:" + msgString);
                try {
                    Thread.sleep(2000);
                }catch (Exception e){

                }finally {
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        // 3.监听队列,设置应答模式true为自动应答，false为手动应答
        channel.basicConsume(QUEUE_NAME, false, defaultConsumer);

    }

}

