package com.dynamicprogram;

/**
 * @Author: renmagical
 * @Date: 2019-03-21 23:19
 * @Description:
 */
public class _62UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0){
            return 0;
        }

        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    path[i][j] = 1;
                }else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        return path[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 7,n = 3;
        int res = new _62UniquePaths().uniquePaths(m, n);
        System.out.println(res);
    }
}
