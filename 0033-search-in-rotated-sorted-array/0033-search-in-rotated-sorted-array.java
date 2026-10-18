class Solution {
    public int search(int[] nums, int target) {
        int pivot = peakIndex(nums);
        if(pivot == -1){
            return binarySearch(nums, 0, nums.length -1, target);
        }

        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums, 0, pivot - 1, target);
        }


        return binarySearch(nums, pivot + 1, nums.length -1 , target);

    }

    private int peakIndex(int[] nums){
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) /2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid - 1])
                return mid - 1;
            if(nums[start] <= nums[mid])
                start = mid + 1;
            else
                end = mid -1;
        }

        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}