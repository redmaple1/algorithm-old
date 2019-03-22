package com.stackandqueue;

import java.util.Stack;

public class _150EvaluateReversePolishNotation {
	
	public static int evalRPN(String[] tokens) {
        int res = 0;
        if(tokens == null || tokens.length == 0)
        	return 0;
        
        if(tokens.length > 1 && (tokens[0].equals("+") || tokens[0].equals("-") 
        		|| tokens[0].equals("*") || tokens[0].equals("/") 
        		|| tokens[1].equals("+") || tokens[1].equals("-") 
        		|| tokens[1].equals("*") || tokens[1].equals("/")))
        	return 0;
        
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < tokens.length; i ++){
        	if(!tokens[i].equals("+") && !tokens[i].equals("-")
        			&& !tokens[i].equals("*") && !tokens[i].equals("/"))
        		stack.push(tokens[i]);
        	
        	if(tokens[i].equals("+")){
        		int a = Integer.parseInt(stack.pop());
        		int b = Integer.parseInt(stack.pop());
        		stack.push(String.valueOf(a + b));
        	}else if(tokens[i].equals("-")){
        		int a = Integer.parseInt(stack.pop());
        		int b = Integer.parseInt(stack.pop());
        		stack.push(String.valueOf(b - a));
        	}else if(tokens[i].equals("*")){
        		int a = Integer.parseInt(stack.pop());
        		int b = Integer.parseInt(stack.pop());
        		stack.push(String.valueOf(a * b));
        	}else if(tokens[i].equals("/")){
        		int a = Integer.parseInt(stack.pop());
        		int b = Integer.parseInt(stack.pop());
        		stack.push(String.valueOf(b / a));
        	}
        }
        return Integer.parseInt(stack.pop());
    }

	public static void main(String[] args) {
		String[] tokens = {"18"};
		int res = evalRPN(tokens);
		System.out.println(res);

	}

}
