package com.qiuxk.DesignPattern;

/**
 * Created by Administrator on 2018/2/2.
 *
 * ����ʽ����
 */
public class SinglePattern2 {
    private static SinglePattern2 singlePattern2=null;

    //˽�л����췽��
    private SinglePattern2(){};

    //���SinglePattern2��ʵ������
    public  SinglePattern2 getInstance(){
        if(null==singlePattern2){
            return new SinglePattern2();
        }else{
            return singlePattern2;
        }
    }
}
