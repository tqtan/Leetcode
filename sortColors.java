# 三色排序  O(n) O(l)
# 三指针排序：zero：0的右边界，two：2的左边界，p当前正在考虑的元素；
# 若当前元素=0，与[右边界+1]置换，p++；若当前元素=2，与[左边界-1]置换；若当前元素=1，p++；
public void sortColors(int[] nums) {
        int zero = -1, two = nums.length, p = 0;
        int temp;
        while(p < two){
            if (nums[p] == 0){
                zero++;
                temp = nums[p];
                nums[p] = nums[zero];
                nums[zero] = temp;
                p++;
            }
            else if (nums[p] == 2){
                two--;
                temp = nums[p];
                nums[p] = nums[two];
                nums[two] = temp;  
            }else
                p++;
        }
    }
