package com.container;

import java.util.Arrays;
import java.util.HashMap;

public class _242 {
	public static boolean isAnagram(String s, String t) {
        HashMap<String,Integer> sMap = new HashMap<String,Integer>();
        for(int i = 0;i < s.length();i ++){
        	if(!sMap.containsKey(String.valueOf(s.charAt(i))))
        		sMap.put(String.valueOf(s.charAt(i)), 1);
        	else
        		sMap.put(String.valueOf(s.charAt(i)), sMap.get(String.valueOf(s.charAt(i))) + 1);
        }
        
        if(s.length() != t.length())
        	return false;
        
        for(int i = 0;i < t.length();i ++){
        	if(sMap.containsKey(String.valueOf(t.charAt(i))) && sMap.get(String.valueOf(t.charAt(i))) > 0)
        		sMap.put(String.valueOf(t.charAt(i)), sMap.get(String.valueOf(t.charAt(i))) - 1);
        	else
        		return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		boolean res = isAnagram(s, t);
		System.out.println(res);
	}
}
