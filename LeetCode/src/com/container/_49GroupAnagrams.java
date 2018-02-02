package com.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class _49GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
        //["eat", "tea", "tan", "ate", "nat", "bat"]
		//每个字符串转成数组，排序后放入map中，将相同的map归为一组
		List<List<String>> res = new ArrayList<List<String>>();
		
		Map<String,Integer> map = new HashMap<String,Integer>();//记录 字符串 和 下标
		Map<String,List<Integer>> comMap = new HashMap<String,List<Integer>>(); //记录 字符串排序后进行比较的map
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < strs.length; i ++){
			map.put(strs[i], i);
			char[] strsArr = strs[i].toCharArray();
			Arrays.sort(strsArr);
			StringBuffer arrBuffer = new StringBuffer();
			for(Character c : strsArr){
				arrBuffer.append(c);
			}
			String arrToString = arrBuffer.toString();
			
			if(comMap.containsKey(arrToString)){
				list = comMap.get(arrToString);
				list.add(i);
				comMap.put(arrToString, list);
			}else{
				List<Integer> list1 = new ArrayList<Integer>();
				list1.add(i);
				comMap.put(arrToString, list1);
			}
		}
	//	Collection<List<Integer>> coll = (Collection<List<Integer>>) comMap.values();
		
		Iterator it = comMap.values().iterator();
		while(it.hasNext()){
			List<Integer> indexList = (List<Integer>)it.next();
			List<String> strRes = new ArrayList<String>();
			for(Integer a : indexList){
				strRes.add(strs[a]);
			}
			res.add(strRes);
		}
		return res;
    }

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res =groupAnagrams(strs);
		System.out.println(res);

	}

}
