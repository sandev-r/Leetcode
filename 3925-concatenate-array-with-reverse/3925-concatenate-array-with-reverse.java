class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] result = new int[nums.length * 2];
        for(int i = 0;i < nums.length * 2;i++){
            if(i < nums.length){
                result[i] = nums[i];
            }
            else{
                int index =((nums.length * 2) - i)- 1;
                result[i] = nums[index];
            }
        }
        return result;
    }
}