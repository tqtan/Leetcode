   # 暴力循环
   public int maxArea(int[] height) {
        int vol = 0;
        for (int i = 0; i < height.length-1; i++){
            for (int j = i+1; j < height.length; j++){
                vol = Math.max(vol,(j-i)*Math.min(height[j],height[i]));
            }
        }
        return vol;
    } 
