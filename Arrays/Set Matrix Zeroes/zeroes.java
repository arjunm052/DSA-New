class zeroes {
    // TC - O(N*M) SC - O(1)
    public void setZeroes(int[][] matrix) {
        // Get the dimensions of the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // This variable will denote whether the column will be set to zero or not
        int colZero = 1;

        // Start traversing the matrix from top row first column
        for (int i = 0; i < rows; i++) {
            // For every row check whether the first column in zero or not
            // If it is zero then set colZero to zero
            if (matrix[i][0] == 0) {
                colZero = 0;
            }

            // Start traversing the columns of the current row
            for (int j = 1; j < cols; j++) {
                // If we encounter a zero then set the 1st element of current row and column to
                // be zero
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // Now we will traverse the array backwards
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                // If we find a a zero in the first element of the row and column of the current
                // element then set that element to zero
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            // After traversing all the columns of the current row except the first one,
            // check whether colZero is set to 0, if it is then make matrix[i][0] to zero
            if (colZero == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}