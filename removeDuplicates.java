    # 双指针法：不需要真的删除数组元素，只需输出不重复元素个数N，输出数组的前N个元素
    # i：不重复元素最后一个索引，j:判断是否重复，重复则跳过，不重复则复制为前面i元素
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
