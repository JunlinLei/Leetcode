    class Solution {
    /**
    1.create an array called LongestSubs to record the best subsequence of dp(i) to dp(n), and fill the LongestSubs with all 1
    2. create a Longest Subsequence counter called LongestCount
    3.for i = 0 to nums.length()
        for j = 0 to i
            if number at nums[i] > number at nums[j]
                set nums[i] = the maximum of LongestSubs[j]+1 or LongestSubs[i];
        set LongestCount = the maximum of LongestCount or LongestSubs[i];
    return LongestCount;
     */
    public int lengthOfLIS(int[] nums) {
        int[] LongestSubs = new int[nums.length];
        Arrays.fill(LongestSubs, 1);
        int LongestCount = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LongestSubs[i] = Math.max(LongestSubs[j] + 1, LongestSubs[i]);
                }
            }
            LongestCount = Math.max(LongestCount,LongestSubs[i]);
        }
        return LongestCount;
    }
}
