class Solution {
    public int alternatingSum(int[] nums) {
        int alterSum = 0;
        for(int i = 0;i < nums.length;i++)
            alterSum += (i % 2 == 0) ? nums[i] : -nums[i];

        return alterSum;
    }
}