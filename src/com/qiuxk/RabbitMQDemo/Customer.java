package com.qiuxk.RabbitMQDemo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:消费者
 * @auth: qiuxk
 * @createDate：2018/2/9 11:56
 **/
public class Customer {

    private  final  static  String QUEUE_NAME="hello,world";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        ConnectionFactory factory = new ConnectionFactory();
        //设置rabbitMq地址
        factory.setHost("localhost");
        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个新的频道
        Channel channel = connection.createChannel();
        //      DefaultConsumer类实现了Consumer接口，
        // 通过传入一个频道，告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery

        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("C [x] Received '" + message + "'");
            }
        };
        //      自动回复队列应答
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
