class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length;
        while(start < end){
            int mid = start + (end - start) /2;

            if(letters[mid] <= target){
                start = mid + 1;
            }
            if(letters[mid] > target){
                end = mid;
            }
        }

        return letters[start % letters.length];
    }
}