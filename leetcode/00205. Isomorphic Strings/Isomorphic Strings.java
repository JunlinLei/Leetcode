class Solution {
    /**
    Hashmap O(n)
    Create a hashmap
    For each character in s
        if the character is contain in the hashmap
            if the the key value corresponding to the character is not equal to the chactater t at string t;
                return false
        else
            create a key value pair from s to t
    return true
        */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            else if(map.containsValue(t.charAt(i))){
                return false;
            }
            else{
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}