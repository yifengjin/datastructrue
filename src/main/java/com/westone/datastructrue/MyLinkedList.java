/*
 * 文件名：MyLinkedList.java
 * 版权：卫士通移动事业部
 * 描述：实现单链表
 * 创建人：wang.li
 * 创建时间：2016年10月8日
 */
package com.westone.datastructrue;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class MyLinkedList<E>
{
    // 头节点
    private Node<E> head = new Node<E>();
    
    // 元素个数
    private int size = 0;
    
    /**
     * 构造函数
     */
    public MyLinkedList()
    {
    }
    
    /**
     * @return the head
     */
    public Node<E> getHead()
    {
        return head;
    }
    
    /**
     * 在指定位置添加元素
     * 
     * @param index
     * @param e
     * @return
     */
    public boolean add(int index, E e)
    {
        // 检查index是否有效
        isPositionIndex(index);
        // 插入头节点
        if (index == 0)
        {
            Node<E> newHead = new Node<E>(e);
            newHead.setNext(head);
            head = newHead;
        }
        else
        {
            Node<E> tmpNode = getNode(index - 1);
            Node<E> next = tmpNode.getNext();
            Node<E> insert = new Node<E>(e);
            insert.setNext(next);
            tmpNode.setNext(insert);
        }
        size += 1;
        return true;
    }
    
    /**
     * 在链表的最后添加元素
     * 
     * @param e
     * @return
     */
    public boolean add(E e)
    {
        Node<E> insert = new Node<E>(e);
        if (head.getItem() == null)
        {
            head.setItem(e);
        }
        else
        {
            lastNode().setNext(insert);
        }
        size += 1;
        return true;
    }
    
    /**
     * 获取链表最后一个元素
     * 
     * @return
     */
    public Node<E> lastNode()
    {
        Node<E> tmp = head;
        while (tmp.getNext() != null)
        {
            tmp = tmp.getNext();
        }
        return tmp;
    }
    
    /**
     * 检查index是否有效
     * 
     * @param index
     */
    private boolean checkPositionIndex(int index)
    {
        return index >= 0 && index <= size;
    }
    
    private boolean checkElementIndex(int index)
    {
        return index >= 0 && index < size;
    }
    
    /**
     * 检查是否有效
     * 
     * @param index
     */
    private void isPositionIndex(int index)
    {
        if (!checkPositionIndex(index))
        {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }
    
    private void isElementIndex(int index)
    {
        if (!checkElementIndex(index))
        {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }
    
    /**
     * index无效时抛出异常信息
     * 
     * @param index
     * @return
     */
    private String outOfBoundMsg(int index)
    {
        return "index:" + index + " out of bound";
    }
    
    /**
     * 获取下标为index的元素
     * 
     * @param index
     * @return
     */
    private Node<E> getNode(int index)
    {
        isPositionIndex(index);
        int i = 0;
        Node<E> tmpNode = head;
        while (i < index)
        {
            i++;
            tmpNode = tmpNode.getNext();
        }
        return tmpNode;
    }
    
    /**
     * 删除下标为index的元素
     * 
     * @param index
     * @return
     */
    public boolean delete(int index)
    {
        isElementIndex(index);
        if (index == 0)
        {
            head = head.getNext();
        }
        else
        {
            Node<E> tmpNode = getNode(index - 1);
            Node<E> next = tmpNode.getNext();
            tmpNode.setNext(next.getNext());
            next.setNext(null);
        }
        size -= 1;
        return true;
    }
    
    /**
     * 删除重复元素
     */
    public void deleteDuplication()
    {
        Node<E> outter = head;
        while (outter.getNext() != null)
        {
            Node<E> inner = outter;
            while (inner.getNext() != null)
            {
                if (outter.getItem().equals(inner.getNext().getItem()))
                {
                    inner.setNext(inner.getNext().getNext());
                    size -= 1;
                }
                else
                {
                    inner = inner.getNext();
                }
            }
            outter = outter.getNext();
        }
    }
    
    /**
     * 获取倒数第n个元素，n从1开始，第一种实现方式
     * 
     * @return
     */
    public E getLastN(int n)
    {
        isPositionIndex(n - 1);
        Node<E> p = head;
        int i = 0;
        while (i < size - n)
        {
            p = p.getNext();
            i++;
        }
        return p.getItem();
    }
    
    /**
     * 获取倒数第n个元素，n从1开始，另一种实现
     * 
     * @param n
     * @return
     */
    public E getLastN1(int n)
    {
        isPositionIndex(n - 1);
        Node<E> p = head;
        while (p != null)
        {
            Node<E> q = p;
            int i = n - 1;
            while (i > 0)
            {
                q = q.getNext();
                i--;
            }
            if (q.getNext() == null)
            {
                return p.getItem();
            }
            p = p.getNext();
        }
        return null;
    }
    
    /**
     * 查找倒数第n个元素，n从1开始，第三种实现方式
     * 
     * @param n
     * @return
     */
    public E getLastN2(int n)
    {
        isElementIndex(n - 1);
        Node<E> former = head;
        Node<E> back = former;
        int i = n - 1;
        while (i > 0)
        {
            // back与former相差n-1
            back = back.getNext();
            i--;
        }
        while (back.getNext() != null)
        {
            back = back.getNext();
            former = former.getNext();
        }
        return former.getItem();
    }
    
    /**
     * 链表反转
     * 
     * @return
     */
    public Node<E> reverse1(Node<E> node)
    {
        // head看作是前一结点，head.getNext()是当前结点，reversedHead是反转后新链表的头结点
        if (node == null || node.getNext() == null)
        {
            return node;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node<E> reversedHead = reverse1(node.getNext());// 先反转后续节点head.getNext()
        node.getNext().setNext(node);// 将当前结点的指针域指向前一结点
        node.setNext(null);// 前一结点的指针域令为null;
        return reversedHead;// 反转后新链表的头结点
    }
    
    // 将当前节点下一个节点缓存后更新当前节点
    public Node<E> reverse2(Node<E> node)
    {
        // 当前节点
        Node<E> cur = node.getNext();
        // 前一个节点
        Node<E> pre = node;
        // 当前节点的下一个节点
        Node<E> tmp = node.getNext().getNext();
        Node<E> revert = new Node<E>();
        while (cur != null)
        {
            
        }
    }
}
