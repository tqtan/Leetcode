    # 不同路径：动态规划
    # 最后一步只有两种情况：向下到/向右到
    # 递推：route[i][j] = route[i-1][j] + route[i][j-1]
    public int uniquePaths(int m, int n) {
        int[][] route = new int[m][n];
        for (int i = 0; i < m; i++)
            route[i][0] = 1;
        for (int j = 0; j < n; j++)
            route[0][j] = 1;
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++)
                route[i][j] = route[i-1][j] + route[i][j-1];
        }
        return route[m-1][n-1];
    }
 
