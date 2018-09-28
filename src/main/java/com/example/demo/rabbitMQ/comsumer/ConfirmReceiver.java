package com.example.demo.rabbitMQ.comsumer;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.example.demo.rabbitMQ.util.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ConfirmReceiver {

	private static final String QUEUE_NAME = "confirm_queue_name";
	
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		//1.获得连接
		Connection connection = ConnectionUtil.getConnection();
		
		//2.创建通道
		Channel channel = connection.createChannel();
		
		//3.申明队列，没有就创建一个
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		//4.创建一个回调的消费者
		Consumer comsumer = new DefaultConsumer(channel){
			@Override
            public void handleDelivery(String consumerTag, Envelope envelope,
            		AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 接收到的消息
                String message = new String(body);
                System.out.println("SimpleReceiver recevie message：" + message + "at " + new Date());
            }
		};
		channel.basicConsume(QUEUE_NAME, comsumer);
	}
}
