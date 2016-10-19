/*
 * 文件名：VisibilityTest.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月13日
 */
package com.westone.thread;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class VisibilityTest
{
    public static void main(String[] args)
        throws Exception
    {
        VisibilityThread v = new VisibilityThread();
        v.start();
        
        Thread.sleep(1000);// 停顿1秒等待新启线程执行
        System.out.println("即将置stop值为true");
        v.stopIt();
        Thread.sleep(1000);
        System.out.println("finish main");
        System.out.println("main中通过getStop获取的stop值:" + v.getStop());
    }
}
