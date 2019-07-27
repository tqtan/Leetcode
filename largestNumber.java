    # 最大数 O(nlogn)
    # 思路：比较ab和ba两种拼接方式下的数值大小
    # 法一：重写Arrays.sort的Comparator使其倒序排列（注：倒序时comparaTo前加-） comparaTo返回值：1交换（前>后），0相等，-1不交换（后>前）
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            str[i] = String.valueOf(nums[i]);
        
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String a, String b){
                System.out.print(-(a+b).compareTo(b+a));
                return -(a+b).compareTo(b+a);
            }
        });
        
        if (str[0].equals("0")) return "0";
        
        String res = "";
        for (int i = 0; i < str.length; i++)
            res = res + str[i];
        
        return res;
    }


   # 法二：快排实现倒序 时间复杂度约为法一1/4
   public String largestNumber(int[] nums) {
        quickSort(nums,0,nums.length-1);
        
        if (nums[0] == 0) return "0";
        
        String res = "";
        for (int i = 0; i < nums.length; i++)
            res = res + String.valueOf(nums[i]);
        
        return res;
    }   
    public void quickSort(int[] nums, int low, int high){
        if (nums == null || low >= high) return;
        int i = low, j = high;
        int pivot = nums[i];
        while (i < j){
            while (i < j && (nums[j]+""+pivot).compareTo(pivot+""+nums[j]) < 0) j--;
            if (i < j) nums[i++] = nums[j];
            while (i < j && (nums[i]+""+pivot).compareTo(pivot+""+nums[i]) > 0) i++;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }

