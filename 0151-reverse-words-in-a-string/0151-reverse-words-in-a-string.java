class Solution {
    public String reverseWords(String s) {
        char[] arr = s.trim().toCharArray();

        // Remove multiple spaces in-place
        int write = 0;
        boolean previousWasSpace = false;

        for (int read = 0; read < arr.length; read++) {
            if (arr[read] == ' ') {
                if (previousWasSpace) {
                    continue;
                }
                previousWasSpace = true;
            } else {
                previousWasSpace = false;
            }

            arr[write++] = arr[read];
        }

        // Reverse the entire meaningful portion
        swap(arr, 0, write - 1);

        // Reverse each word
        int start = 0;

        for (int i = 0; i <= write; i++) {
            if (i == write || arr[i] == ' ') {
                swap(arr, start, i - 1);
                start = i + 1;
            }
        }

        return new String(arr, 0, write);
    }

    private void swap(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}