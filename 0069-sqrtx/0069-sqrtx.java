class Solution {
    public int mySqrt(int x) {
        if(x < 0) return -1;
        if(x == 0) return 0;

        double guess = x / 2.0;
        double tol = 1e-10;
        while(true){
            double root = (guess + x / guess) / 2.0;

            if(Math.abs(root - guess) < tol){
                return (int)root;
            }

            guess = root;
        }

    }
}