package com.container;

import java.util.HashMap;
import java.util.Map;

public class _447NumberOfBoomerangs {
	public static int numberOfBoomerangs(int[][] points) {
		/**
		 * Input:
			[[0,0],[1,0],[2,0]]
			
			Output:
			2
			
			Explanation:
			The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
		 */
		//思路：将i当做枢纽点，遍历一遍，计算其余点到i点的距离，将距离 和 该距离出现的次数 放入一个map中，
		//若map.value = n > 1,说明有至少两个点到i点的距离相等，那么就有 n * (n - 1)种选择，使两点到i点距离相等
		int res = 0;
		for(int i = 0; i< points.length; i++){
			Map<Integer, Integer> record = new HashMap<Integer,Integer>();
			for(int j = 0; j < points.length; j ++){
				if(i != j){
					int distance = dis(points[i],points[j]);
					if(record.containsKey(distance)){
						record.put(distance, record.get(distance) + 1);
					}else{
						record.put(distance, 1);
					}
				}
			}
			
			for(Integer dis : record.keySet()){
				res += record.get(dis) * (record.get(dis) - 1);
			}
		}
        return res;
    }
	
	private static int dis(int[] pa,int[] pb){
		return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
				(pa[1] - pb[1]) * (pa[1] - pb[1]);
	}

	public static void main(String[] args) {
		int[][] points = {{0,0},{1,0},{2,0}};
		int res = numberOfBoomerangs(points);
		System.out.println(res);

	}

}
