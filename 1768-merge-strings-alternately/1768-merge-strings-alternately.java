class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int lw = w1.length >= w2.length ? w1.length : w2.length;
        char[] output = new char[w1.length + w2.length];
        int oi = 0;

        for(int i = 0; i < lw; i++){
            if (i < w1.length){
                output[oi] = w1[i];
                ++oi;
            } 
            if (i < w2.length){
                output[oi] = w2[i];
                ++oi;
            }
        }

        return new String(output);
    }
}