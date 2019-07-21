   # O(logn) 二分查找
   public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        int mid;
        while (low < high){
            mid = (low+high)/2;
            if (nums[mid] > nums[mid+1])
                high = mid;
            if (nums[mid] < nums[mid+1])
                low = mid + 1; 
        }
        return low;
    }
