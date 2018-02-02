package com.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _18FourSum {
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<>();
        if(nums == null || nums.length < 4) return res;
        
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length - 3; i++){
        	for(int j = i + 1; j < nums.length - 2; j++){
        		int l = j + 1;
        		int r = nums.length - 1;
        		
        		while(l < r){
        			sum = nums[i] + nums[j] + nums[l] + nums[r];
        			if(sum == target){
        				List<Integer> inList = new ArrayList<>();
        				inList.add(nums[i]);
        				inList.add(nums[j]);
        				inList.add(nums[l]);
        				inList.add(nums[r]);
        				if(!set.contains(inList)){
        					set.add(inList);
        					res.add(inList);
        				}
        				l ++;
        				r --;
        			}else if(sum < target){
        				l ++;
        			}else{
        				r --;
        			}
        		}
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> res = fourSum(nums, target);
		System.out.println(res);

	}

}
