package com.container;

import java.util.HashSet;

public class _217ContainsDuplicate {
	
	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i ++){
        	if(record.contains(nums[i]))
        		return true;
        	record.add(nums[i]);
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = {1,0,4,2,3};
		boolean res = containsDuplicate(nums);
		System.out.println(res);

	}

}
