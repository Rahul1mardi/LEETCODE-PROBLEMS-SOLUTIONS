class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            result = (char) (result ^ s.charAt(i));     // as there is no duplicates letters string is converted char 
        }
        for (int i = 0; i < t.length(); i++) {
            result = (char) (result ^ t.charAt(i));      // now in result char are of s string are already stored .so we xor it with each char of t string to make it zero and unique char is left .
        }
        
        return result;         // on calling method this will give as output 
    }
}

// by Rahul marandi
