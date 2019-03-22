package com.dynamicprogram;

/**
 * @Author: renmagical
 * @Date: 2019-03-21 18:15
 * @Description:
 */
public class _279PerfectSquare {
    public int numSquares(int n){
        if (n <= 0){
            throw new IllegalArgumentException("n should be greater than zero.");
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            //求解memo[i]
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i ; j++) {
                tmp = Math.min(tmp, memo[i - j * j]);
            }
            memo[i] = tmp + 1;
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 13;
        int res = new _279PerfectSquare().numSquares(n);
        System.out.println(res);
    }
}
