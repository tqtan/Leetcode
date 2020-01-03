    # 1.二分法找到旋转点（当前数>后一个数则后一个数为旋转点）；2.和首尾数比较大小确定搜索坐标范围；3.二分法查找目标值
    # 注：a.特殊情况判断：nums为空，nums.length=1
    #    b.找到旋转点后确定坐标范围时，目标值与首尾元素比较大小（一定要包含相等情况！）
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] != target) return -1;
        int l = 0;
        int r = nums.length-1;
        if  (nums[0] > nums[nums.length-1]){
            int p = 0;
            while (l <= r){
                int m = (l+r)/2;
                if (nums[m] > nums[m+1]){
                    p = m+1;
                    break;
                }     
                else if (nums[l] < nums[m])
                    l = m;
                else
                    r = m;
            }
            if (target >= nums[0]){
                l = 0;
                r = p-1;
            }else if (target <= nums[nums.length-1]){
                l = p;
                r = nums.length-1;
            }else
                return -1;
        }
        while (l <= r){
            int med = (l+r)/2;
            if (target == nums[med])
                return med;
            else if (target < nums[med])
                r = med - 1;
            else
                l = med + 1;
        }
        return -1;
    }
