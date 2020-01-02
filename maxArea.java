   # 暴力循环 O(n²) O(l)
   public int maxArea(int[] height) {
        int vol = 0;
        for (int i = 0; i < height.length-1; i++){
            for (int j = i+1; j < height.length; j++){
                vol = Math.max(vol,(j-i)*Math.min(height[j],height[i]));
            }
        }
        return vol;
    } 

   # 双指针法   O(n) O(l)
   # 步骤：两个指针初始化一头一尾，每次比较保留至今为止最大的面积res，每次较短侧的指针向内移动，只需一次遍历
   # 原理：比当前面积更大的可能性只能是改变较短一侧，期望内部有比较短侧有更高的高度；改变较长侧时，最短高度不变，宽度变小，面积不可能更大
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length-1;
        while(l < r){
            res = Math.max(res,Math.min(height[l],height[r])*(r-l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return res;
    }
