class Solution {
    public int longestSubarray(int[] nums) {
       int slow = 0, fast  = 0, zeroCount = 0, k = 1, maxCount = 0;
       while(fast < nums.length){
            if(nums[fast] == 0)
                zeroCount++;
            if(zeroCount > k){
                while(zeroCount > k){
                    if(nums[slow] == 0)
                        zeroCount--;
                    slow++;
                }
            }

            fast++;
            maxCount = Math.max(maxCount, (fast - slow) - 1);
       } 

       return maxCount;
    }
}