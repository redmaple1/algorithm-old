package com.dynamicprogram;

/**
 * @Author: renmagical
 * @Date: 2019-03-21 20:09
 * @Description:
 */
public class _91DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0")){
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        //dp[i]表示从1 ~ i 的decode ways的个数
        dp[0] = 1;

        if (isValid(s.substring(0,1))){
            dp[1] = 1;
        }else {
            dp[1] = 0;
        }

        for (int i = 2; i <= s.length(); i++){
            if (isValid(s.substring(i-1,i))){
                dp[i] += dp[i - 1];
            }
            if (isValid(s.substring(i-2,i))){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    private boolean isValid(String s){
        if (s.charAt(0) == '0'){
            return false;
        }
        int code = Integer.parseInt(s);
        return code >= 1 && code <= 26;
    }

    public static void main(String[] args) {
        String s = "226";
        int res = new _91DecodeWays().numDecodings(s);
        System.out.println(res);
    }
}
