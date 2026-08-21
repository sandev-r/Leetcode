class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ptrG = 0, ptrS = 0;

        while(ptrG < g.length && ptrS < s.length){
            if (s[ptrS] >= g[ptrG]){
                ptrG++;
                ptrS++;
            }
            else
                ptrS++;
        }

        return ptrG;
    }
}