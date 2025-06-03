
class Solution {
    /*
    Two pointer method
        create two pointer:
            one pointer at loop through the entire array, another pointer point to where we store the item
        int k = 1 //store the return value
        loop through the list:
            if(list at first pointer <list at second pointer){
                list at [first pointer+1]= second pointer's value
                k++
            }
*/
     
    public int removeDuplicates(int[] nums) {
        int i = 1;
        for(int j = 1;j< nums.length;j++){
            if(nums[i-1]<nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

