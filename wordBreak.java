    # 单词拆分：动态规划O(n平方)
    # 递推：将单词拆分为（0，i）+(i,L)；用j拆分i=（0，j）和(j,i)是否同时为true
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
