/*
 * 文件名：Solution.java
 * 版权：卫士通移动事业部
 * 描述：TODO(用一句话描述该文件做什么)
 * 创建人：wang.li
 * 创建时间：2016年10月19日
 */
package com.westone.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang.li
 *
 *         一句话描述该类型的作用
 */
public class Solution
{
    // Given nums = [2, 7, 11, 15], target = 9,
    //
    // Because nums[0] + nums[1] = 2 + 7 = 9,
    // return [0, 1].
    public int[] twoSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int[] index = new int[2];
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return null;
    }
    
    /**
     * 参考别人代码后改进
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumIm(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            // int[] index = new int[2];
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    // index[0] = i;
                    // index[1] = j;
                    return new int[] {i, j};
                }
            }
        }
        // 抛出异常，而不是返回null
        throw new IllegalArgumentException("No two sum solution");
    }
    
    /**
     * 使用hashMap
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target)
    {
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            numsMap.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement) && i != numsMap.get(complement))
            {
                return new int[] {i, numsMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    /**
     * 使用hashMap只遍历一次
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOneLoop(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];
            if (map.containsKey(complement))
            {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    // You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
    // each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    //
    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode sumList = new ListNode(0);
        ListNode node = sumList;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null)
        {
            int val1 = node1 == null ? 0 : node1.val;
            int val2 = node2 == null ? 0 : node2.val;
            int sum = node.val + val1 + val2;
            // if..else可以换成除和余
            if (sum >= 10)
            {
                node.val = sum - 10;
                node.next = new ListNode(1);
            }
            else
            {
                node.val = sum;
                node.next = new ListNode(0);
            }
            node = node.next;
            node1 = (node1 == null) ? null : node1.next;
            node2 = (node2 == null) ? null : node2.next;
        }
        
        return removeLast(sumList);
    }
    
    private ListNode removeLast(ListNode head)
    {
        ListNode node = head;
        while (node.next != null)
        {
            if (node.next.next == null && node.next.val == 0)
            {
                node.next = null;
                return head;
            }
            node = node.next;
        }
        return head;
    }
    
    /**
     * 根据别人答案改进版
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersIm(ListNode l1, ListNode l2)
    {
        ListNode sumList = new ListNode(0);
        ListNode node = sumList;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;
        while (node1 != null || node2 != null)
        {
            int val1 = node1 == null ? 0 : node1.val;
            int val2 = node2 == null ? 0 : node2.val;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            node1 = (node1 == null) ? null : node1.next;
            node2 = (node2 == null) ? null : node2.next;
        }
        if (carry > 0)
        {
            node.next = new ListNode(1);
        }
        return sumList.next;
    }
    
    public ListNode addTwoNumbersIm1(ListNode l1, ListNode l2)
    {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null)
        {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0)
        {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(5);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);
        //
        ListNode l2 = new ListNode(5);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);
        
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbersIm(l1, l2);
        System.out.println(node);
    }
}
