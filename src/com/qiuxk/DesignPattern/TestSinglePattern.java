package com.qiuxk.DesignPattern;

/**
 * Created by Administrator on 2018/2/2.
 */
public class TestSinglePattern {
    //因为SinglePattern的构造方法是私有 没有办法调用
   // SinglePattern singlePattern =new SinglePattern();

    //只能通过SinglePattern的静态方法 得到唯一的实例对象
   SinglePattern singlePattern= SinglePattern.getInstance();

    SinglePattern single= singlePattern.getInstance;
    String outStr=single.pritln;
  //  System.out.println("");
    System.out.println("outStr");
}
