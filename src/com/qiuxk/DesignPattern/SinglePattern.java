package com.qiuxk.DesignPattern;

/**
 * Created by Administrator on 2018/2/2.
 *
 * ����ʽ����
 */
public class SinglePattern {

    private static SinglePattern singlePattern=new SinglePattern();
    //˽�л����췽��
    private SinglePattern(){

    }
    //Ψһ����ʵ������ķ���
    public static SinglePattern getInstance(){
        return singlePattern;
    }

    public String pritln(){
        return "�˷����Ƕ���ʽ����ģʽ";
    }
}
