package com.eureka.demo.rabbitmqrouting;

import com.eureka.demo.rabbitmq.MQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RoutingProducer {

	//交换机名称
	private static final String DESTINATION_NAME = "my_routing_estination";

	public static void main(String[] args) throws IOException, TimeoutException {
		// 1.建立mq连接
		Connection connection = MQConnectionUtils.newConnection();
		// 2.创建通道
		Channel channel = connection.createChannel();
		// 3.生产者绑定交换机 参数1 交换机名称 参数2 交换机类型
		channel.exchangeDeclare(DESTINATION_NAME, "direct");
		String routingKey = "sms";
		// 4.创建消息
		String msg = "my_routing_生产的消息内容"+routingKey;
		System.out.println("消息是:" + msg);
		// 5.发送消息
		channel.basicPublish(DESTINATION_NAME, routingKey, null, msg.getBytes());
		// 6.关闭连接
		channel.close();
		connection.close();

	}

}
