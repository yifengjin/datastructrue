/*
 * 文件名：Node.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月8日
 */
package com.westone.datastructrue;

/**
 * @author wang.li
 *
 *         节点
 */
public class Node<E>
{
    // 节点内容
    private E item;
    
    // 下一个节点
    private Node<E> next;
    
    /**
     * @param item
     * @param next
     */
    public Node(E item, Node<E> next)
    {
        this.item = item;
        this.next = next;
    }
    
    /**
     * @param item
     */
    public Node(E item)
    {
        this.item = item;
    }
    
    public Node()
    {
    }
    
    /**
     * @return the item
     */
    public E getItem()
    {
        return item;
    }
    
    /**
     * @param item the item to set
     */
    public void setItem(E item)
    {
        this.item = item;
    }
    
    /**
     * @return the next
     */
    public Node<E> getNext()
    {
        return next;
    }
    
    /**
     * @param next the next to set
     */
    public void setNext(Node<E> next)
    {
        this.next = next;
    }
    
}
