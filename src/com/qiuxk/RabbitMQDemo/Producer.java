package com.qiuxk.RabbitMQDemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 生产者
 * @auth: qiuxk
 * @createDate：2018/2/9 11:05
 **/
public class Producer {

    private final  static String QUEUE_NAME="hello,world";
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory=new ConnectionFactory();

        //设置RabbitMq地址
        factory.setHost("localhost");

        //创建一个新的连接
        Connection connection=null;
        try {
             connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        //创建一个频道
        Channel channel=null;
        try {
             channel = connection.createChannel();
        } catch (IOException e) {
            try {
                e.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        //      声明一个队列
        // -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同）
        // 也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message="hello world~";
        //发送到消息队列中
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));
        //关闭频道和连接
        channel.close();
        connection.close();
    }
}
