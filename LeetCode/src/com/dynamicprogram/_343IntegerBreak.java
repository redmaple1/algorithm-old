package com.dynamicprogram;

import java.util.Arrays;

/**
 * @Author: renmagical
 * @Date: 2019-03-21 17:16
 * @Description:
 */
public class _343IntegerBreak {
    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int integerBreak(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n should be greater than 0.");
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            //求解memo[i]
            for (int j = 1; j <= i - 1; j++){
                memo[i] = max3(memo[i], j * (i - j), j * memo[i-j]);
            }
        return memo[n];
    }


    /**********************递归记忆化搜索
     /*private int[] memo;

     public int integerBreak(int n) {
     if (n < 1){
     throw new IllegalArgumentException("n should be greater than 0.");
     }
     memo = new int[n + 1];
     Arrays.fill(memo,-1);

     return breakInteger(n);
     }

     //将n分割(至少分割成两部分)，可以获得的最大乘积
     private int breakInteger(int n) {
     if (n == 1){
     return 1;
     }

     if (memo[n] != -1){
     return memo[n];
     }

     int res = -1;
     for (int i = 1; i <= n - 1; i++){
     //将n分成 i + (n - i) 或者 (i + 对(n-i)进行分割)
     res = max3(res,i * (n - i),i * breakInteger(n - i));
     }
     memo[n] = res;
     return res;
     }*/

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int n = 10;
        int res = new _343IntegerBreak().integerBreak(n);
        System.out.println(res);
    }
}
