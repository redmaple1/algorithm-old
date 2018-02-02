package com.container;

import java.util.Arrays;

public class _16ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length < 3) return 0;
		int res = nums[0] + nums[1] + nums[2];
		int minSum = Math.abs( res - target);
       
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
        	int l = i + 1;
        	int r = nums.length - 1;
        	
        	int sum = 0;
        	while(l < r){
        		sum = nums[i] + nums[l] + nums[r];
        		
        		if(sum < target){
        			l ++;
        		}else{
        			r --;
        		}
        		int abs = Math.abs(target - sum);
        		
        		if( abs < minSum){
    				minSum =abs;
    				res = sum;
    			}
        		
        	}
	
        }
        return res;
    }
	public static void main(String[] args) {
		int[] nums = {0,2,1,-3};
		int target = 1;
		int res = threeSumClosest(nums, target);
		System.out.println(res);

	}

}
