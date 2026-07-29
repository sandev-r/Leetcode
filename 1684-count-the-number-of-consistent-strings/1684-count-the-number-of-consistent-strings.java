class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedArr = new boolean[26];
        for(char ch: allowed.toCharArray()){
            allowedArr[ch - 'a'] = true;
        }

        int count = 0;
        for(int i = 0;i < words.length;i++){
            boolean isConsistent = true;
            for(int j = 0;j < words[i].length();j++){
                if(!allowedArr[words[i].charAt(j) - 'a']){
                    isConsistent = false;
                    break;
                }
            }

            if(isConsistent)
                count++;
        }

        return count;
    }
}