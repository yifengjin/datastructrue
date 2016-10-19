/*
 * 文件名：InterruptedVisibilityTest.java
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
public class InterruptedVisibilityTest
{
    public void think()
    {
        System.out.println("新线程正在执行");
        while (true)
        {
            if (checkInterruptedStatus())
                break;
        }
        System.out.println("新线程退出循环");
    }
    
    private boolean checkInterruptedStatus()
    {
        return Thread.currentThread().isInterrupted();
    }
    
    public static void main(String[] args)
        throws Exception
    {
        final InterruptedVisibilityTest test = new InterruptedVisibilityTest();
        Thread thinkerThread = new Thread("Thinker")
        {
            public void run()
            {
                test.think();
            }
        };
        thinkerThread.start();
        Thread.sleep(1000);// 等待新线程执行
        System.out.println("马上中断thinkerThread");
        thinkerThread.interrupt();
        System.out.println("已经中断thinkerThread");
        thinkerThread.join(3000);
        if (thinkerThread.isAlive())
        {
            System.err.println("thinkerThread未能在中断后3s停止");
            System.err.println("JMV bug");
            System.err.println("主线程中检测thinkerThread的中断状态:" + thinkerThread.isInterrupted());
        }
    }
}
