package com.container;

import java.util.HashMap;

public class _290WordPattern {
	public static boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        HashMap<Character, String> maps = new HashMap<Character,String>();
        String[] strs = str.split(" ");
        
        if(patterns.length != strs.length)
        	return false;
        
        for(int i = 0; i < patterns.length; i ++){
        	if(maps.containsKey(patterns[i])){
        		if(!strs[i].equals(maps.get(patterns[i])))
        			return false;
        	}else{
        		if(maps.containsValue(strs[i]))
        			return false;
        		maps.put(patterns[i], strs[i]);
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		boolean res = wordPattern(pattern, str);
		System.out.println(res);
	}
}
