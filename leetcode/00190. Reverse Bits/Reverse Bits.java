 public class Solution {
    /**
    set j  = 0
    from i = 0 to 32
        First,left shift one bit.Second, only take the last bit of n by using AND operation with 1. Third take the OR gate of j and last bit of n.
        Then right shift n with 1 position and assign back to n;
    return j;
     */
    int j = 0;
    public int reverseBits(int n) {
        for(int i = 0;i<32;i++){
            j = (j<<1) | n&1;
            n>>=1;
        }
            return j;

    }
}