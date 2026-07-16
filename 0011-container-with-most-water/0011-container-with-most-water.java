class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int maxContainer = 0;

        while(start < end){
            int l = height[start];
            int r = height[end];

            int minHeight = Math.min(l, r);

            int width = end - start;

            int water = minHeight * width;

            maxContainer = Math.max(maxContainer, water);

            if(l < r)
                start++;
            else 
                end--;
        }

        return maxContainer;
    }
}