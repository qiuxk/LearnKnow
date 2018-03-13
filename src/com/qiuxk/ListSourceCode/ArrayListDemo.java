package com.qiuxk.ListSourceCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auth: qiuxk
 * @createDate：2018/2/5 14:24
 **/
public class ArrayListDemo {
    public static void main(String[] args) {
        //Arraylist 是实现了基于动态数组的数据结构
        //ArrayList 特性 ：1.插入 读取有序
        //                2.可以为空元素和重复元素

        //初始数组是10 add方法会调用grow方法 对数组实现扩容 每次是1.5倍+1
        // ArrayList 遍历时很快 但是插入、删除都需要移动到后面的元素 效率略差   不如LinkedList
        //ArrayList 继承AbstractList抽象类
        // 实现List<E>, RandomAccess, Cloneable, java.io.Serializable类

        //重写了 AbstractList中的indexOf方法
   /* public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }*/
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        List<String> list2 =new ArrayList<String>(12);
        int a=5;
      //  list.ensureCapacity(a);
        System.out.println(list.size());
        System.out.println(a>>3);
        Object[] objects = list.toArray();
        System.out.println(objects.length);
    }

}
