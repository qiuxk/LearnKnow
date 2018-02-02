package com.qiuxk.DesignPattern;

/**
 * Created by Administrator on 2018/2/2.
 *
 * 饿汉式单例
 */
public class SinglePattern {

    private static SinglePattern singlePattern=new SinglePattern();
    //私有化构造方法
    private SinglePattern(){

    }
    //唯一返回实例对象的方法
    public static SinglePattern getInstance(){
        return singlePattern;
    }

    public String pritln(){
        return "此方法是饿汉式单例模式";
    }
}
