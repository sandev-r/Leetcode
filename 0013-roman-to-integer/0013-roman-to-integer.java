class Solution {

    private int value(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            default: return 1000; // M
        }
    }

    public int romanToInt(String s) {
        int sum = 0;
        int prev = value(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int curr = value(s.charAt(i));

            if (prev < curr)
                sum -= prev;
            else
                sum += prev;

            prev = curr;
        }

        return sum + prev;
    }
}