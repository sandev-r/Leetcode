/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndex(mountainArr);
        int firstValue = orderAgnosticBinarySearch(mountainArr, target, 0, peak);
        if(firstValue != -1)
            return firstValue;
        return orderAgnosticBinarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    private int peakIndex(MountainArray nums){
        int start = 0, end = nums.length() - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums.get(mid) > nums.get(mid + 1))
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    private int orderAgnosticBinarySearch(MountainArray nums, int target, int start, int end){
        boolean isAsc = nums.get(start) < nums.get(end);
        while(start <= end){
            int mid = start + (end - start) / 2;
            int midValue = nums.get(mid);
            if(midValue == target)
                return mid;
            if(isAsc){
                if(target < midValue)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else{
                if(target < midValue)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }
}