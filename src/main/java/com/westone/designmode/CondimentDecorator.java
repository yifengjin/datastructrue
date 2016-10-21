/*
 * 文件名：CondimentDecorator.java
 * 版权：卫士通移动事业部
 * 描述：装饰者模式，调料类
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public abstract class CondimentDecorator extends Beverage
{
    public abstract String getDescription();
}
