package com.qiuxk.DesignPattern;

/**
 * Created by Administrator on 2018/2/2.
 */
public class TestSinglePattern {
    //��ΪSinglePattern�Ĺ��췽����˽�� û�а취����
   // SinglePattern singlePattern =new SinglePattern();

    //ֻ��ͨ��SinglePattern�ľ�̬���� �õ�Ψһ��ʵ������
   SinglePattern singlePattern= SinglePattern.getInstance();

    SinglePattern single= singlePattern.getInstance;
    String outStr=single.pritln;
  //  System.out.println("");
    System.out.println("outStr");
}
