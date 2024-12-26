class Solution {
    /**
    Solution:
     */
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] output = new int[nums.length];
        Arrays.fill(prefix,1);
        Arrays.fill(suffix,1);
        int curr = 1;
        for(int i = 1;i < nums.length;i++){
            curr = curr * nums[i-1];
            prefix[i] = curr;
        }
        curr = 1;
        for(int i = nums.length-2; i >= 0; i--){
            curr = curr * nums[i+1];
            suffix[i] = curr;
        }

        for(int i = 0;i< nums.length;i++){
            output[i] = prefix[i]*suffix[i];
        }
        return output;
    }
}