class Solution {
    public int compress(char[] chars) {
        if(chars.length <= 1) return chars.length;
        int i = 0, j = 1, k = 0;
        while(j < chars.length){
            while(j < chars.length && chars[i] == chars[j]){
                j++;
            }
            int count = j - i;
            chars[k++] = chars[i];
            if (count > 1){
                String strCount = String.valueOf(count);
                for(char ch: strCount.toCharArray()){
                    chars[k++] = ch;
                }
            }

            i = j;
        }

        return k;
    }
}