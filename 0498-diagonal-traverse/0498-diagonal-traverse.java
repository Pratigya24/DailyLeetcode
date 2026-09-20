class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if ( mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        
        int row = 0, col = 0;
        boolean goingUp = true; // We start by going up-right
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            
            if (goingUp) {
                // If we hit the right boundary, we must move down to the next row
                if (col == n - 1) {
                    row++;
                    goingUp = false;
                } 
                // If we hit the top boundary, we must move right to the next column
                else if (row == 0) {
                    col++;
                    goingUp = false;
                } 
                // Otherwise, just keep moving up-right
                else {
                    row--;
                    col++;
                }
            } else {
                // If we hit the bottom boundary, we must move right to the next column
                if (row == m - 1) {
                    col++;
                    goingUp = true;
                } 
                // If we hit the left boundary, we must move down to the next row
                else if (col == 0) {
                    row++;
                    goingUp = true;
                } 
                // Otherwise, just keep moving down-left
                else {
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}