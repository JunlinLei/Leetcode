class Solution {
    /**
    1. check if the length of s2 + s1 ! = s3; return false if it's the not same length
    2.
    create a 2d list to store the result of subproblems
        dp[0][0] is always true since zero length compare to zero length is always true;
        consider only character in s1
        for i = 0 to s1.length()   
            dp[i][0] =  dp[i-1][0] and s1.charAt(i) == s3.charAt(i);

        for j = 0 to s2.length()
            dp[0][j] = dp[0][j-1] and s2.charAt(j) == s3.charAt(j);

        for i = 0 to s1.length()
            for j = 0 to s2.length()
                dp[i][j] = (dp[i-1][j] and s1[i-1] == s3[i+j-1]) or (dp[i][j-1] and s2[i-1] == s2[j-1] ==s3[i+j-1])

        return  dp[m][n]

        */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(n+m !=s3.length()){
            return false;
        }

        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1;i<m+1;i++){
            dp[i][0] = dp[i-1][0] & (s1.charAt(i-1) == s3.charAt(i-1));
        }

        for(int j = 1;j<n+1;j++){
            dp[0][j] = dp[0][j-1] & (s2.charAt(j-1) == s3.charAt(j-1));
        }

        for(int i = 1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                dp[i][j] = (dp[i-1][j] & (s1.charAt(i-1) == s3.charAt(i+j-1))) | (dp[i][j-1] & (s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }

        return (dp[m][n]);
    }
}