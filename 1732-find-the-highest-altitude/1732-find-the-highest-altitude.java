class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0, netGain = 0;
        for(int n: gain){
            netGain+=n;
            highestAltitude = Math.max(highestAltitude, netGain);
        }

        return highestAltitude;
    }
}