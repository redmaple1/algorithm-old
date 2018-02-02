package com.container;

import java.util.HashMap;
import java.util.Map;
//时间复杂度O(n^2)
//空间复杂度O(n^2)
public class _454FourSumII {
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if(A == null || B == null || C == null || D == null)
			throw new IllegalArgumentException("Illegal argument");
		
        //将C + D 的和的可能性放进一个查找表，记录每种和出现的频次
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0; i < C.length; i ++)
			for(int j = 0; j < D.length; j++){
				int sum = C[i] + D[j];
				if(map.containsKey(sum)){
					map.put(sum, map.get(sum) + 1);
				}else{
					map.put(sum, 1);
				}
			}
		
		int res = 0;
		for(int i = 0; i < A.length; i++)
			for(int j = 0; j < B.length; j++){
				if(map.containsKey(0 - A[i] - B[j]))
					res += map.get(0 - A[i] - B[j]);
			}
		
		return res;
				
    }

	public static void main(String[] args) {
		int[] A = {1,2};
		int[] B = {-2,-1};
		int[] C = {-1,2};
		int[] D = {0,2};
		int res = fourSumCount(A, B, C, D);
		System.out.println(res);

	}

}
