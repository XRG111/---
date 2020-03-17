package com.eureka.demo.amqp;

import com.eureka.demo.rabbitmq.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 * @author admin
 */
public class Producer {
    public static final String QUEUE_NAME = "admin_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1获取连接
        Connection connection = MQConnectionUtils.newConnection();
        //2创建通道
        Channel channel = connection.createChannel();
        //3创建队列声明,第二个参数：是否持久化到硬盘
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        try {
            //开启事务
            channel.txSelect();
            for (int i = 0; i < 10; i++) {
                String msg = "这是一个队列"+i;
                //4发送消息
                channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
                //int n = 1/0;
                //提交事务
                channel.txCommit();
            }
        }catch (Exception e){
            System.out.println("事务已回滚");
            channel.txRollback();

        }finally {
            channel.close();
            connection.close();
        }



    }
}
