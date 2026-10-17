class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        int start = 1, end = num;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long sqrt = (long) mid * mid;
            if(sqrt == num){
                return true;
            }
            if(sqrt > num){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return false;
    }
}