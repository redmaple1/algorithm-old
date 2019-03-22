package com.testString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ReverseInt {
    public int reverse(int x) {
        try{
            int flag = 1;
            if(x < 0){
                flag = -1;
                x = -x;
            }
            LinkedList<Character> stack = new LinkedList<>();
            String xStr = String.valueOf(x);
            String resultStr = "";
            for(int i = 0;i < xStr.length();i++){
                char tempChar = xStr.charAt(i);
                stack.add(tempChar);
            }
            for(int i = 0;i < xStr.length();i++){
                char outChar = stack.removeLast();
                resultStr += outChar;
            }
            int result = 0;
            return Integer.valueOf(resultStr) * flag;
        }catch(Exception e){
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new ReverseInt().reverse(x);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}
