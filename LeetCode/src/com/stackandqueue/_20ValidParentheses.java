package com.stackandqueue;

import java.util.Stack;

public class _20ValidParentheses {
	
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(c == '(' || c == '[' || c == '{')
        		stack.push(c);
        	else{
        		if(stack.size() == 0)
        			return false;
        		
        		char out = stack.peek();
        		stack.pop();
        		
        		char match;
        		if(c == ')')
        			match = '(';
        		else if(c == ']')
        			match = '[';
        		else{
        			assert(c == '}');
        			match = '{';
        		}
        		
        		if(out != match)
        			return false;
        	}
        }
        if(stack.size() != 0)
        	return false;
        return true;
    }

	public static void main(String[] args) {
		String str = "{[()]}";
		boolean res = isValid(str);
		System.out.println(res);

	}

}
