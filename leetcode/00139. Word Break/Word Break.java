class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length() + 1];
        Arrays.fill(arr, false);
        arr[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (i - wordDict.get(j).length() >= 0) {
                    if (s.substring(i - wordDict.get(j).length(), i).equals(wordDict.get(j))) {
                        if (arr[i - wordDict.get(j).length()] == true) {
                            arr[i] = true;
                        }
                    }
                }
            }
        }
        return arr[s.length()];
    }
}
