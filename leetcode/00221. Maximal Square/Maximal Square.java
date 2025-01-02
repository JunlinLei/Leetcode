class Solution {
    
public int maximalSquare(char[][] matrix) {
        /**
         * run time: O(m*n)
         * recurrent process:
         *  if matrix[i][j] is 1
         *    we are going to find the min of dp[i-1][j], dp[i][j-1], dp[i-1][j-1] +1, where those three are the max sub-square it can get to
         *       update max
         */
        int n = matrix[0].length;
        int m = matrix.length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max,dp[0][i]);
        }

        for (int j = 0; j < m; j++) {
            dp[j][0] = matrix[j][0] - '0';
            max = Math.max(max,dp[j][0]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }

        return max*max;
    }
    
    /**
     *  original solution:
     *      Run time: O(m*n*ln(min(m|n)))
     *     recurrent process:
     *      keep checking its left element and its upper element is 1, and dp[i-1][j-1] can have a larger sub-square. dp[i-1][j-1] contains largest square size at matrix[i-1][j-1]
     *      for l = 1 to ((i - l >= 0) & ((j - l >= 0)))
     *         if its left element and its upper element is 1 and its dp[i-1][j-1] is greater than l^2
     *              square = Math.pow(l + 1, 2);
     */

    /*
    public int maximalSquare(char[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (dp[0][i] > max) {
                max = dp[0][i];
            }
        }

        for (int j = 0; j < m; j++) {
            dp[j][0] = matrix[j][0] - '0';
            if (dp[j][0] > max) {
                max = dp[j][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    for (int l = 1; ((i - l >= 0) & ((j - l >= 0))); l++) {
                        if ((matrix[i - l][j] == '1') & (matrix[i][j - l] == '1') & dp[i - 1][j - 1] >= (int) Math.pow(l, 2)) {
                            int square = (int) Math.pow(l + 1, 2);
                            dp[i][j] = square;
                        } else {
                            break;
                        }
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
    */
}
