class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int start = 0, end = ch.length - 1;
        while(start < end){
            if(!isVowel(ch[start])){
                start++;
            }
            if(!isVowel(ch[end])){
                end--;
            }
            if(isVowel(ch[start]) && isVowel(ch[end])){
                char c = ch[start];
                ch[start] = ch[end];
                ch[end] = c;
                start++;
                end--;
            }

        }
        return new String(ch);
    }

    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'|| ch =='A' || ch == 'E' || ch == 'I' || ch == 'O'|| ch == 'U' ) {
            return true;
        }
        return false;
    }
}