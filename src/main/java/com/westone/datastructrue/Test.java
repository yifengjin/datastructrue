/*
 * 文件名：Test.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月8日
 */
package com.westone.datastructrue;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class Test
{
    public static void main(String[] args)
    {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        // list.deleteDuplication();
        // list.delete(0);
        // list.delete(4);
        String a = list.getLastN2(1);
        list.reverse1(list.getHead());
        System.out.println(a);
    }
}
