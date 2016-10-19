/*
 * 文件名：VisibilityThread.java
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
public class VisibilityThread extends Thread
{
    private volatile boolean stop;
    
    public void run()
    {
        int i = 0;
        System.out.println("start loop.i=" + i);
        while (!getStop())
        {
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }
    
    public void stopIt()
    {
        stop = true;
    }
    
    public boolean getStop()
    {
        return stop;
    }
}
