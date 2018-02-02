package com.container;

import java.util.HashSet;

public class _219ContainsDuplicateII {
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(record.contains(nums[i]))
        		return true;
        	
        	record.add(nums[i]);
        	
        	//保持record中最多有k个元素
        	if(record.size() == k + 1)
        		record.remove(nums[i - k]);        	
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = {0,3,0,4,7};
		int k = 2;
		boolean res = containsNearbyDuplicate(nums, k);
		System.out.println(res);

	}

}
