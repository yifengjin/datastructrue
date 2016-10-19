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
    
    public static void main(String[] args)
    {
        int[] nums = {3, 2, 4};
        Solution solution = new Solution();
        int[] a = solution.twoSumHash(nums, 6);
        System.out.println(a[0] + "," + a[1]);
    }
}
