package com.stackandqueue;

import java.util.Iterator;
import java.util.Stack;

public class _71SimplifyPath {
	
	public static String simplifyPath(String path) {
		if(path.length() <=0 )
			return path;
		
        Stack<String> stack = new Stack<String>();
        String[] list = path.split("/");
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < list.length; i++){
        	if(list[i].equals(".") || list[i].length() == 0)
        		continue;
        	else if(!list[i].equals(".."))
        		stack.push(list[i]);
        	else{
        		if(!stack.isEmpty())
        			stack.pop();
        	}
        }
        Iterator<String> it = stack.iterator();
        while(it.hasNext()){
        	sb.append("/"+(String)it.next());
        }
        String res = sb.toString();
        return res.length() == 0 ? "/" : res;
    }

	public static void main(String[] args) {
		String path = "/.../";
		String res = simplifyPath(path);
		System.out.println(res);

	}

}
