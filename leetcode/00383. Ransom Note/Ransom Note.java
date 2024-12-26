class Solution {
    /**
    brute force O(n^2):
        1.For each letter in string ransomNote, We find a pair of letter match in magazine. 
            If we find the letter, then we replace same the letter we found in magazine.
            Else return false

    
    Using Hashmap O(2n):
        Create a Hashmap as <Character,value> to record all the character in magazine.
        1. For each letter in string magazine,
            we check if the hashmap contain that character,
                if yes, we increment the number to that character by one
                else put that character in and value as one into hashmap
        For each letter in ransomNote,
            we check if the letter is contain in the hasmap
                if yes, we decrement the number count by one in hashmap
                    if the value is less than 1 then we remove the character in hashmap
                else return false
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<magazine.length();i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            }
            else{
                map.put(magazine.charAt(i),1);
            }
        }
        for(int i = 0;i<ransomNote.length();i++){
            if(map.containsKey(ransomNote.charAt(i))){
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
                if(map.get(ransomNote.charAt(i))<1){
                    map.remove(ransomNote.charAt(i));
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    
}