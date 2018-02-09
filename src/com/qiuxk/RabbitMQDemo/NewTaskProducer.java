package com.qiuxk.RabbitMQDemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 生产者发送多条消息
 * @auth: qiuxk
 * @createDate：2018/2/9 14:48
 **/
public class NewTaskProducer {

    private  static final String NEW_TASK_PRODUCER="task_queue";
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        //创建工厂连接
        factory.setHost("localhost");
        //创建连接
        Connection connection = factory.newConnection();
        //创建频道
        Channel channel = connection.createChannel();

        //分发消息
        for(int i=0;i<5;i++){
            String  message="hello space"+i;
            channel.basicPublish("",NEW_TASK_PRODUCER, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("utf-8"));
            System.out.print(" [x] Sent '" + message + "'");
        }

        //频道关闭
        channel.close();
        //连接关闭
        connection.close();

    }
}
