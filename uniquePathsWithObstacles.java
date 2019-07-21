    # 不同路径2：动态规划  O(m*n)
    # [0][0]：有障碍=0，否则=1；第1行/列初始化：（无障碍时）当前格=前一个格
    # 每个格子有障碍=0，无障碍则递推：route[i][j] = route[i-1][j] + route[i][j-1];
    # 改进：直接利用 obstacleGrid 作为 DP 数组，不再额外声明数组
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] route = new int[r][c];
        route[0][0] = 1;
        for (int i = 1; i < r; i++){
            if (obstacleGrid[i][0] != 1)
                route[i][0] = route[i-1][0];
        }
        for (int j = 1; j < c; j++){
            if (obstacleGrid[0][j] != 1)
                route[0][j] = route[0][j-1];
        }
        for (int i = 1; i < r; i++){
            for (int j = 1; j < c; j++){
                if (obstacleGrid[i][j] != 1)
                    route[i][j] = route[i-1][j] + route[i][j-1];
            }     
        }
        
        return route[r-1][c-1];
    }
