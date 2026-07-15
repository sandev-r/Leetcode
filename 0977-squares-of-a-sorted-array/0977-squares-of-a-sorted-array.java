class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            nums[i] = (int) Math.pow(nums[i], 2);
        }

        int[] sortedArray = new int[nums.length];
        int left = 0, right = nums.length - 1, pos = nums.length - 1;

        while(left <= right){
            if(nums[left] > nums[right]){
                sortedArray[pos] = nums[left++];
            }else{
                sortedArray[pos] = nums[right--];
            }
            pos--;
        }

        return sortedArray;
    }
}