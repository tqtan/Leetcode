# 两个数组的交集 II
# 法一：先排序预处理，再遍历两个数组，若相等则加入list，否则元素较小的数组指针+1
# 法二：将nums1存为hashmap，统计其每个元素（key）的计数（value）；遍历nums2若其元素存在于map（map.containsKey）则加入list且map计数-1
public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;){
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        
        return res;
    }
