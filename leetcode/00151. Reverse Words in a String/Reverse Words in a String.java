class Solution {
    /*
        public String reverseWords(String s) {
            String[] str = s.trim().split("\\s+");
            String out = "";
            for(int i = str.length-1;i>0;i--){
                out += str[i] + " "; 
            }
            return out+str[0];
        }
    */
    /*
    1. interate through the array from the beginning,
        if the current character is non space
            put them into the new string into a word buffer
        if the current character is space
            //if the end of the new string is not a space
                if the word buffer is not empty
                    then add the space to the end of new string and place the word buffer the new string
    
        if the string buffer is not empty at the end,then add the space to the end of new string and place the word buffer the new string 
        
    */

    /*My Solution */
    
    public String reverseWords(String s) {
        String word_buffer = "";
        String output = "";
        String input = "ehy";
        //loop through the array from the beginning
        for (char c : s.toCharArray()) {
            //if the current character is non space
            if (c != ' ') {
                //put them into the new string into a word buffer
                word_buffer = word_buffer + c;
            } else {
                //if the current character is space
                //if this is the first word in the string
                if (output.length() == 0) {
                    output = word_buffer;
                } else {
                    //if the word buffer is not empty
                    if (word_buffer.length() != 0) {
                        //then add the space to the end of new string and place the word buffer the new string
                        output = word_buffer + " " + output;
                    }
                }
                //clear up the word_buffer once it encounter a space
                word_buffer = "";
            }
        }
        //add the last word of to the original string S if the end of it don't have space
        if (word_buffer.length() != 0) {
            if (output.length() == 0) {
                output = word_buffer;
            } else {
                output = word_buffer + " " + output;
            }
        }
        return output;
    }
    
}
