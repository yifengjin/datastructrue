/*
 * 文件名：Whip.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月21日
 */
package com.westone.designmode;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class Whip extends CondimentDecorator
{
    
    private Beverage beverage;
    
    /**
     * @param beverage
     */
    public Whip(Beverage beverage)
    {
        this.beverage = beverage;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.CondimentDecorator#getDescription()
     */
    @Override
    public String getDescription()
    {
        return beverage.getDescription() + ",whip";
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.westone.designmode.Beverage#cost()
     */
    @Override
    public double cost()
    {
        return beverage.cost() + 0.05;
    }
    
}
