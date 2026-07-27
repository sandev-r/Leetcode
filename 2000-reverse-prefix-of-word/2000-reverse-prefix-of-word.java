class Solution {
    public String reversePrefix(String word, char ch) {
        char[] array = word.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == ch) {
                int left = 0;
                int right = i;

                while (left < right) {
                    char temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;

                    left++;
                    right--;
                }

                return new String(array);
            }
        }

        return word;
    }
}