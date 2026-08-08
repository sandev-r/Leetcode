class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        int count = 0;
        for(int i = 0;i < flowerbed.length;i++){
            
            int left = (i == 0) ? 0: flowerbed[i - 1];
            int right = (i == flowerbed.length -1) ? 0: flowerbed[i+1];

            if(left == 0 && flowerbed[i] == 0 && right == 0){
                flowerbed[i] = 1;
                count++;
            }

            if(count >= n)
                return true;
        }

        return false;
    }
}