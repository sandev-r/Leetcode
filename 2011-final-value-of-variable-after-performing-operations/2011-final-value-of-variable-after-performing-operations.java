class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for(String ch: operations){
            if(ch.charAt(0) == '-' || ch.charAt(ch.length() - 1) == '-') X--;
            else X++;
        }

        return X;
    }
}