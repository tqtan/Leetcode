    # 倒序判断每一位元素是否为10，若为10则前一位+1，该位置0
    # 若第一位为10，则新声明数组输出（比原数组位数+1）
    public int[] plusOne(int[] digits) {
        digits[digits.length-1] = digits[digits.length-1] + 1;
        for (int a = digits.length-1; a > 0; a--){
            if (digits[a] == 10){
                digits[a-1] = digits[a-1] + 1;
                digits[a] = 0;
            }else
                return digits;
        }
        if (digits[0] == 10){
            int[] ans = new int[digits.length+1];
            digits[0] = 0;
            for (int m = digits.length - 1; m >= 0; m--)
                ans[m+1] = digits[m];
            ans[0] = 1; 
            return ans;
        }else
            return digits;
    }
