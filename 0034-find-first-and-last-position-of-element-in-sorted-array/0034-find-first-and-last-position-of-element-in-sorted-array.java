class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int start = search(nums, target, true);
        if(start != -1){
            int end = search(nums, target, false);
            result[0] = start;
            result[1] = end;
        }
        
        return result;
    }

    int search(int[] nums, int target, boolean isFirstStartIndex){
        int start = 0, end = nums.length -1;
        int answer = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                answer = mid;
                if(isFirstStartIndex){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }

        return answer;
    }
}