// class Solution {
//     public int minCost(int[][] grid) {
//         int n = grid[0].length;
//         boolean[][] dp = new boolean[n][1024];  // dp[j][x]: XOR x can reach column j of the row above
//         dp[0][0] = true;
//         for (int[] row : grid)
//             for (int j = 0; j < n; j++) {
//                 boolean[] next = new boolean[1024];
//                 for (int x = 0; x < 1024; x++)
//                     if (dp[j][x] || j > 0 && dp[j - 1][x]) next[x ^ row[j]] = true;  // from above or from the left
//                 dp[j] = next;
//             }
//         int x = 0;
//         while (!dp[n - 1][x]) x++;
//         return x;
//     }
// }


class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];
        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int val = grid[i][j];

                if (i > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[i - 1][j][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[i][j - 1][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
