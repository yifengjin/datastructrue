/*
 * 文件名：SayHiEmlement.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年11月2日
 */
package com.westone.annotation;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class SayHiEmlement
{
    // 普通的方法
    public void SayHiDefault(String name)
    {
        System.out.println("Hi, " + name);
    }
    
    // 使用注解并传入参数的方法
    @SayHiAnnotation(paramValue = "Jack")
    public void SayHiAnnotation(String name)
    {
        System.out.println("Hi, " + name);
    }
    
    // 使用注解并使用默认参数的方法
    @SayHiAnnotation
    public void SayHiAnnotationDefault(String name)
    {
        System.out.println("Hi, " + name);
    }
}
