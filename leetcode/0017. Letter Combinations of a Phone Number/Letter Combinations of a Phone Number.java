class Solution {
    /**
    1.create a return array called output
    2.create a list that store all the letters;
    3.create a method to call backtrack and return to the recursive method
        parameter: digits, index, combination, output, digitToLetter

        if index == digits.length();
            add combination to output
            return
        string s = digitToLetter[digits.charAt(index) -'0']
        for(char letter : letters.toCharArray()){
            add the letter to combination
            call the method backtrack with digits,index+1,combination,output, digitToLetter
            remove the last letter we just add from combination
        }
    4.return output
    */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> output = new ArrayList<>();
        ArrayList<String> digitToLetter = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
        backtrack(digits, 0, new StringBuilder(), output, digitToLetter);

        return output;
    }

    public void backtrack(String digits, int index, StringBuilder combination, List<String> output, ArrayList<String> digitToLetter) {
        if (index == digits.length()) {
            output.add(combination.toString());
            return;
        }

        String s = digitToLetter.get(digits.charAt(index) - '2');
        for (char letter : s.toCharArray()) {
            combination.append(letter);
            backtrack(digits, index + 1, combination, output, digitToLetter);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
