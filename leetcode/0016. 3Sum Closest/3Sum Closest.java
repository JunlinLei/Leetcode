import java.util.Arrays;

public class _16_3Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        int sum = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(sum-target);
        int result = sum;
        Arrays.sort(nums);
        for(int i = 0;i<=nums.length-2;i++){
            int j = i+1,k = nums.length-1;
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                int newdiff = Math.abs(sum-target);
                if(newdiff<diff){
                    diff = newdiff;
                    result = sum;
                }
                if(sum<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return result;
    }

    public void stin() {
        int[] nums = new int[]{-1, 2, 1, -4};
        threeSumClosest(nums,1);
    }
}

