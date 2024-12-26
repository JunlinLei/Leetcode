class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] list = s.split(" ");
        if(list.length != pattern.length()){
            return false;
        }
        for(int i = 0; i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(list[i])){
                    return false;
                }
            }
            else if(map.containsValue(list[i])){
                return false;
            }
            else{
                map.put(pattern.charAt(i), list[i]);
            }
        }
        return true;
    
    }
}