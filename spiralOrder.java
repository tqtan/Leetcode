    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int m1 = 0, m2 = matrix.length-1;
        int n1 = 0, n2 = matrix[0].length-1;
        while (m1 <= m2 && n1 <= n2){
            for (int n = n1; n <= n2; n++) 
                ans.add(matrix[m1][n]);
            for (int m = m1+1; m <= m2; m++)
                ans.add(matrix[m][n2]);
            if (m1 < m2 && n1 < n2){
                for (int n = n2-1; n >= n1; n--) 
                    ans.add(matrix[m2][n]);
                for (int m = m2-1; m >= m1+1; m--)
                    ans.add(matrix[m][n1]);
            }
            n1++;
            n2--;
            m1++;
            m2--;
        }
        
        return ans;
    }
