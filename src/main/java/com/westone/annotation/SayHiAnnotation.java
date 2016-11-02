/*
 * 文件名：SayHiAnnotation.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年11月2日
 */
package com.westone.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
@Retention(RetentionPolicy.RUNTIME)
// 表示注解在运行时依然存在
@Target(ElementType.METHOD)
// 表示注解可以被使用于方法上
public @interface SayHiAnnotation
{
    String paramValue() default "johness"; // 表示我的注解需要一个参数 名为"paramValue" 默认值为"johness"
}
