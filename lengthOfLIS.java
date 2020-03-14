  # 最长上升子序列
  # 法一：动态规划 O(n²) O(n)
  # 状态转移方程：dp[i]=max(dp[j]+1,dp[i])，dp为当前num[i]下子序列的最大长度
  # 每个nums[i]遍历其前面所有元素j，若num[i]>num[j]，则比较是否用dp[j]+1更新dp[i]；每个nums[i]计算完时更新res
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    
    
    # 法二：动态规划+二分查找 O(nlogn)  O(n)
    # 建立tail保存上升子序列（不一定是实际序列值，但长度正确），遍历nums，将nums[i]用二分查找插入tail中；
    # nums[i]覆盖tail中比它大的元素中最小的（保证子序列尽可能长）;若tail都比它小则放在tail最后且res长度+1
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        int[] tail = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            tail[i] = 0;
            int l = 0, r = res;
            while (l < r){
                int m = (l + r) / 2;
                if (tail[m] < nums[i]) l = m + 1;
                else r = m;
            }
            tail[l] = nums[i];
            if (r == res) res++;
        }
        return res;
    }
