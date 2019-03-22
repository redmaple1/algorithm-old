package com.dynamicprogram;

/**
 * @Author: renmagical
 * @Date: 2019-03-21 23:43
 * @Description:
 */
public class _63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] path = new int[m][n];
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        path[0][0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    path[i][j] = 0;
                }else {
                    if (i == 0 && j == 0){
                        path[i][j] = 1;
                    }else if (obstacleGrid[i][j] == 1){
                        path[i][j] = 0;
                    }else if (i == 0 && j != 0){
                        path[i][j] = path[i][j - 1];
                    }else if (i !=  0 && j == 0){
                        path[i][j] = path[i - 1][j];
                    }else {
                        path[i][j] = path[i - 1][j] + path[i][j - 1];
                    }
                }
            }
        return path[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstractGrid = {{0,0,0},
                                {0,1,0},
                                {0,0,0}};
        int res = new _63UniquePathsII().uniquePathsWithObstacles(obstractGrid);
        System.out.println(res);
    }
}
