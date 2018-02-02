package com.testString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestNoRepeatSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abcabcdd";
		int result = lengthOfLongestSubstring1(test);
		
		System.out.println(result);
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        for(int i = 0,j = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i - j + 1);
            
        }
        return max;
    }
	
	public static int lengthOfLongestSubstring1(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    while (j < s.length()) {
	        if (!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j++));
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i++));
	        }
	    }
	    
	    return max;
	}
}
