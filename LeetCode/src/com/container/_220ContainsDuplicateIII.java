package com.container;

import java.util.TreeSet;

public class _220ContainsDuplicateIII {
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		//TreeSet<Integer>在 nums[i] + t会出现整型溢出的情况，所以定义时这样定义：TreeSet<Long>
        TreeSet<Long> record = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i ++){
        	//abs(nums[i] - x) <= t
        	//-->   nums[i] - t  --> t --> nums[i] + t
        	if(record.ceiling((long)nums[i] - (long)t) != null &&
        			record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t)
        		return true;
        	
        	record.add((long)nums[i]);
        	
        	if(record.size() == k + 1)
        		record.remove((long)nums[i - k]);
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = {0,2,4,3,7};
		int k = 2;
		int t = 0;
		boolean res = containsNearbyAlmostDuplicate(nums, k, t);
		System.out.println(res);

	}

}
