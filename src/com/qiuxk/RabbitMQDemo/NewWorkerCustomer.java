package com.qiuxk.RabbitMQDemo;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 消费者1   去读取NewTaskProducer中的消息
 * @auth: qiuxk
 * @createDate：2018/2/9 14:58
 **/
public class NewWorkerCustomer {

    private  static  final  String NEW_TASK_PRODUCER="task_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //final 修改对象  对应的引用是不能变的 但是值是可以变的
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(NEW_TASK_PRODUCER,true,false,false,null);
        //每次从消息队列中获取的数量
        channel.basicQos(1);
        final Consumer consumer =new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println("Worker1 [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("Worker1 [x] Done");
                    //消息处理确认
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }

            }
        };
        //消息消费完成确认
        channel.basicConsume(NEW_TASK_PRODUCER,false,consumer);
    }

    private  static  void doWork(String task){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
