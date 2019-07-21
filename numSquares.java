    # 完全平方数：动态规划
    # 两层循环：i为2到n；j为用1到i平方将i拆分为 [j*j]+[i-j*j]
    # 递推公式：min = Math.min(min,dp[j*j]+dp[i-j*j]);
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++){
                if (j * j == i){
                    min = 1;
                    break;
                }
                min = Math.min(min,dp[j*j]+dp[i-j*j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
