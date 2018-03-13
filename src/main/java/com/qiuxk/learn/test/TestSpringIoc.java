package com.qiuxk.learn.test;

import com.spring.ioc.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiuxk on 2018/3/13.
 */
public class TestSpringIoc {

    @Test
    public  void testUser(){
        //����spring�����ļ�������Userʵ��
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Application.xml");

       User user=(User) applicationContext.getBean("user");
       System.out.println(user);
       user.add();
    }


}
