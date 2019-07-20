    # O(m*n)   O(l)
    # 标记0元素所处行、列的第一个位置为0；若行、列第一位置为0元素则该行、列所有元素置0
    # 第一行、第一列单独判断是否含0元素
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int row1 = 1, col1 = 1;
        for (int j = 0; j < n; j++){
            if (matrix[0][j] == 0)
                row1 = 0;
        }
        for (int i = 0; i < m; i++){
            if (matrix[i][0] == 0)
                col1 = 0;
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        if (row1 == 0){
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
        if (col1 == 0){
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
        
    }
