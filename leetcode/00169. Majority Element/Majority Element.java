class Solution {
    public int majorityElement(int[] nums) {
    /**Initial Attemp:
        1. map (O(n))
            1. Use an map to keep track the frequency of all elements
            2. In Each interation, a element will increase the frequency for corresponding value base on their value as key
            3. At last, find the greatest value in all entry and return their key*/
    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int max_value = 0;
    int max_key = 0;
    for(int num:nums){
        if(hm.containsKey(num)){
            hm.put(num,hm.get(num)+1);
        }
        else{
            hm.put(num,1);
        }
    }
    Iterator<Map.Entry<Integer,Integer>> itr = hm.entrySet().iterator();
    while(itr.hasNext()){
        Map.Entry<Integer,Integer> entry = itr.next();
        if(entry.getValue()>max_value){
            max_value = entry.getValue();
            max_key = entry.getKey();
        }
    }
    return max_key;
    }
}