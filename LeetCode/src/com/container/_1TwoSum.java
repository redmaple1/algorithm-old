package com.container;

import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(map.containsKey(target - nums[i])){
        		int[] res = {i,map.get(target - nums[i])};
        		return res;
        	}
        	map.put(nums[i], i);
        }
        throw new IllegalStateException("The input has no solution.");
    }
	
	public static void showArr(int[] res){
		for(int num : res){
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] res = twoSum(nums, target);
		showArr(res);

	}

}
