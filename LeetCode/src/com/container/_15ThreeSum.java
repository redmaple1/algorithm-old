package com.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _15ThreeSum {
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public static List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length < 3) return res;
		
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 0; i < len - 2; i++){
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			
			//寻找两个数与nums[i]的和为0；
			find(nums,i + 1,len - 1,nums[i]);
			
		}
		return res;
    }
	
	public static void find(int[] nums,int begin,int end,int target){
		int l = begin;
		int r = end;
		while(l < r){
			if(nums[l] + nums[r] + target == 0){
				List<Integer> inList = new ArrayList<>();
				inList.add(nums[l]);
				inList.add(nums[r]);
				inList.add(target);
				//放入结果集中
				res.add(inList);
				while(l < r && nums[l] == nums[l+1]) l ++;
				while(l < r && nums[r] == nums[r-1]) r --;
				l ++;
				r --;
			}else if(nums[l] + nums[r] + target < 0){
				l ++;
			}else{
				r --;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(nums);
		System.out.println(res);

	}

}
