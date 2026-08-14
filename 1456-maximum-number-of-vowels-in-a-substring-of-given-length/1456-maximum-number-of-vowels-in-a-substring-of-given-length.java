class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0;i < k;i++){
            char ch = s.charAt(i);
            if(isVowel(ch))
                count++;
        }

        int maxCount = count;
        for(int i = k; i < s.length();i++){
            char ch = s.charAt(i);
            char pastCh = s.charAt(i - k);
            if(isVowel(pastCh))
                count--;
            if(isVowel(ch))
                count++;

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;

    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}