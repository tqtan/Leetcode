    # 先转置后换列
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
