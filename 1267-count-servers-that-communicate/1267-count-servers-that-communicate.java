class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] indexRowCount = new int[n];
        int[] indexColCount = new int[m];
        
        int count =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    indexColCount[j]++;
                    indexRowCount[i]++;
                }
            }
        }


        int resultServers = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && (indexColCount[j] > 1 || indexRowCount[i] > 1)){
                    resultServers++;
                }
            }
        }

        return resultServers;
    }
}