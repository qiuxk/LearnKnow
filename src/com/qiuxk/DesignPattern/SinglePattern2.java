package com.qiuxk.DesignPattern;

/**
 * Created by Administrator on 2018/2/2.
 *
 * 懒汉式单例
 */
public class SinglePattern2 {
    private static SinglePattern2 singlePattern2=null;

    //私有化构造方法
    private SinglePattern2(){};

    //获得SinglePattern2的实例对象
    public  SinglePattern2 getInstance(){
        if(null==singlePattern2){
            return new SinglePattern2();
        }else{
            return singlePattern2;
        }
    }
}
