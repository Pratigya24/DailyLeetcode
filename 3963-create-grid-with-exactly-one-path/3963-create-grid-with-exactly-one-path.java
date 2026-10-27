class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        
        // Fill the whole grid with walls '#'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }
        
        // Create a single simple path from (0,0) to (m-1, n-1)
        // First go all the way right along the top row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        
        // Then go all the way down along the rightmost column
        for (int i = 1; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        
        // Convert the 2D char array to String[]
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}