class Solution {
    /**
     * O(n^2)
    dp */
    public int rob(int[] nums) {
        int[] arr = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        arr[0] = nums[0];
        arr[1] = nums[1];
        int max = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            int local_max = 0;
            for(int j = i-2; j>=0;j--){
                if(nums[i]+arr[j]>local_max){
                    local_max = nums[i]+arr[j];
                }
            }
            arr[i] = local_max;
            if(local_max>max){
                max = local_max;
            }
        }
        return max;
    }
}