    # 最长回文子串：
    # 法一：动态规划
    #      1.最大公共子串：原字符串和翻转字符串找最大公共子串
    #      2.P(i,j)=(P(i+1,j−1) and Si==Sj)      P(i,i+1)=(Si==Si+1)
    # 法三：中心扩展法
    # 1.分成对称中心为某一字符、两字符中间两种情况；
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        int maxlen = 0;
        int start = 0;
        for (int i = 1; i < s.length(); i++){
            int len = 0;
            for (int j = 1; j < Math.min(i+1,s.length()-i);j++){
                if (s.charAt(i-j) == s.charAt(i+j))
                    len = j;            
                else
                    break;
            }
            if (2*len + 1 > maxlen){
                maxlen = 2*len + 1;
                start = i - len;
            }
            for (int j = 1; j <= Math.min(i,s.length()-i); j++){
                if (s.charAt(i-j) == s.charAt(i+j-1))
                    len = j;
                else
                    break;
            }
            if (2*len > maxlen){
                maxlen = 2*len;
                start = i - len;
            }   
        }
        String ans = "";
        for (int i = start; i < start + maxlen; i++)
            ans = ans + s.charAt(i);
        return ans;
    }
    
    # 2.代码优化
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = centerexpend(s,i,i);     //奇数
            int len2 = centerexpend(s,i,i+1);   //偶数
            int len = Math.max(len1,len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);
    }  
    public int centerexpend(String s, int l, int r){
        int L = l, R = r;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
