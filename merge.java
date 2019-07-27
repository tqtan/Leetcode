# 合并区间 O(logn)
# 先按每个区间左边界从小到大排序，再比较当前区间i右边界与下一区间i+1左边界大小
# 若区间i右边界<=区间i+1左边界，更新当前右边界right=max(区间i右边界，区间i+1右边界)
# 注：sort排序时,lamda表达式时间复杂度远高于重写new Comparaotr(){}
public int[][] merge(int[][] intervals) {
        if (intervals.length <=1 || intervals == null) return intervals;
        List<int[]> list = new ArrayList<>();
//        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        for (int i = 0; i < intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length-1 && right >= intervals[i+1][0]){
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{left,right});
        }
        
        return list.toArray(new int[list.size()][2]);
    }
