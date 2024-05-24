class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /**
         * 1.Two pointer
         * 1. One pointer on left and another pointer on right of the array
         * 2.If result greater than target, move right,
         * 3.Else move left
         */
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j]) == target) {
                return new int[] { i + 1, j + 1 };
            } else if ((numbers[i] + numbers[j]) > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }
}