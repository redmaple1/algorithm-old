package com.container;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _451SortCharactersByFrequency {
	
	public static String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        int[] map = new int[256];
        int max = 0;
        for(char ch : s.toCharArray()){
        	map[ch]++;
        	max = Math.max(max, map[ch]);
        }
        String[] buckets = new String[max + 1];
        for(int i = 0; i < 256; i ++){
        	String str = buckets[map[i]];
        	if(map[i] > 0)
        		buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char)i); 
        }
        
        StringBuffer strb = new StringBuffer();
        for(int i = max; i >= 0; i --){
        	if(buckets[i] != null){
        		for(char ch : buckets[i].toCharArray()){
        			for(int j = 0; j < i; j ++)
        				strb.append(ch);
        		}
        	}
        }
        return strb.toString();
        
    }

	public static void main(String[] args) {
		String s = "Aabb";
		String res = frequencySort(s);
		System.out.println(res);
	}

}
