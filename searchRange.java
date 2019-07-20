    # 二分查找logn
    # 查找左边界：相等时向左移动high = mid -1；
    # 查找右边界：相等时向右移动low = mid + 1.
    
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        int left = twoSearch(nums,target,true);
        int right = twoSearch(nums,target,false);
        return new int[]{left,right};
    }
    
    public int twoSearch(int[] nums, int target, boolean left){
        int a = 0, b = nums.length-1;
        int index = -1;
        while (a <= b){
            int mid = (a+b)/2;
            if (target < nums[mid])
                b = mid - 1;
            else if (target > nums[mid])
                a = mid + 1;
            else{
                if (left){
                    b = mid - 1;
                    index = mid;
                }else{
                    a = mid + 1;
                    index = mid;
                }
            }
        }
        return index;
    }
