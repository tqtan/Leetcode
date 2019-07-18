    public int maxProduct(int[] nums) {
        int pro = Integer.MIN_VALUE;
        int c_max = 1,c_min = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                int temp = c_max;
                c_max = c_min;
                c_min = temp;
            }
            c_max = Math.max(c_max * nums[i],nums[i]);
            c_min = Math.min(c_min * nums[i],nums[i]);
            pro = Math.max(c_max,pro);
        }
        return pro;
    }
