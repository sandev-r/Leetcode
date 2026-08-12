class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int current : nums) {
            if (current <= first) {
                first = current;
            } else if (current <= second) {
                second = current;
            } else {
                return true;
            }
        }

        return false;
    }
}