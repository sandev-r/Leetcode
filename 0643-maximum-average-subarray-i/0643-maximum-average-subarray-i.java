class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for(int i = 0;i < k;i++){
            windowSum+=nums[i];
        }

        int maxAvg = windowSum;
        for(int i = k;i < nums.length;i++){
            windowSum -= nums[i - k];
            windowSum += nums[i];
            maxAvg = Math.max(maxAvg, windowSum);
        }

        return (double) maxAvg / k;
        
    }
}