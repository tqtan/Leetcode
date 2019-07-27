    # 摆动排序II   O(nlogn)
    # 原数组从小到大排序后，前一半0~len/2倒序排列，后一半len/2+1~len-1间隔插入前一半中
    public void wiggleSort(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums,0,copy,0,nums.length);
        Arrays.sort(copy);
        for (int i = 0; i < copy.length/2; i++){
            nums[2*i] = copy[(copy.length-1)/2-i];
            nums[2*i+1] = copy[copy.length-1-i];
        }
        if (nums.length % 2 == 1)
            nums[nums.length-1] = copy[0];
    }   
