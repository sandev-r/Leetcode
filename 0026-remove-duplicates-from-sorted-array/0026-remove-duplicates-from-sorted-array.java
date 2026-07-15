class Solution {
    public int removeDuplicates(int[] nums) {
        int writePointer = 0;
        for(int readPointer = 1;readPointer < nums.length;readPointer++){
            if(nums[writePointer] != nums[readPointer] ){
                nums[++writePointer] = nums[readPointer];
            }
        }
        return writePointer+1;
    }
}