package com.container;

import java.util.HashSet;

public class _202HappyNumber {
	public static boolean isHappy(int n) {
        HashSet<Integer> nSet = new HashSet<Integer>();
        while(n != 1){
        	int t = 0;
        	while(n > 0){
        		t += (n % 10) * (n % 10);
        		n /= 10;
        	}
        	n = t;
        	if(nSet.contains(n))
        		break;
        	else
        		nSet.add(n);
        		
        }
        return n == 1 ? true : false;
    }
	
	public static void main(String[] args) {
		int n = 19;
		boolean happy = isHappy(n);
		System.out.println(happy);
	}
}
