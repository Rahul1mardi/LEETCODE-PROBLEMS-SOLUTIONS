class Solution {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            countMap.put(charS, countMap.getOrDefault(charS, 0) + 1);
            countMap.put(charT, countMap.getOrDefault(charT, 0) - 1);
        }

        for (int val : countMap.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;  
    }
}