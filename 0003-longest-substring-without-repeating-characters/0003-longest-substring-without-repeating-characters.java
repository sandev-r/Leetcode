class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0, maxLen = 0;

        while(fast < s.length()){
            char ch = s.charAt(fast);
            if(!set.contains(ch)){
                set.add(ch);
                fast++;
            }
            else{
                while(set.contains(ch)){
                    set.remove(s.charAt(slow));
                    slow++;
                }

                set.add(ch);
                fast++;
            }

            int windowLen = fast - slow;
            maxLen = Math.max(maxLen, windowLen);
        }

        return maxLen;
        
    }
}