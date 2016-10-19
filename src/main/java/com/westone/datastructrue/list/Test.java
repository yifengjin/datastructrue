/*
 * 文件名：Test.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月8日
 */
package com.westone.datastructrue.list;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class Test
{
    
    public AtomicInteger inc = new AtomicInteger(0);
    
    public void increase()
    {
        inc.addAndGet(1);
    }
    
    public static void main(String[] args)
    {
        final Test test = new Test();
        for (int i = 0; i < 10; i++)
        {
            new Thread()
            {
                public void run()
                {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                };
            }.start();
        }
        
        while (Thread.activeCount() > 1)
            // 保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
