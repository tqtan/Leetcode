# 输入一个正整数 target ，输出所有和为 target 的连续正整数序列
# 法一：O(nlogn) 双指针,左指针范围1-target/2，右指针从左指针+1开始，直到==target
public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        int left = 1;
        while (left < (target + 1) / 2){
            int right = left + 1;
            int n = 1;
            int sum = left;
            while (right <= target / 2 + 1){
                sum += right;
                n++;
                if (sum == target){
                    int[] ans = new int[n];
                    for (int i = 0; i < n; i++) ans[i] = left + i;
                    res.add(ans);
                    break;
                }else if (sum > target) break;
                right++;
            }
            left++;
        }
        return res.toArray(new int[res.size()][]);
    }
    
    # 优化
    # 法二：利用求根公式，确定左指针后判断是否存在整数使得==target（判断条件：b²-4ac为整数 && 分子为偶数） O(n)
    
    # 法三：滑动窗口，左右指针同时开始，循环条件为左指针范围，若sum<target，右指针++；若sum>target，左指针++；==后左指针++。
    #       两指针均不需要左移!!!  O（n）
        public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        int left = 1;
        int right = 2;
        while (left < right){
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target){
                int[] ans = new int[right-left+1];
                for (int i = 0; i < right - left + 1; i++) ans[i] = left + i;
                res.add(ans);
                left++;
            }else if (sum < target) right++;
            else left++;
        }
        return res.toArray(new int[res.size()][]);
    }
