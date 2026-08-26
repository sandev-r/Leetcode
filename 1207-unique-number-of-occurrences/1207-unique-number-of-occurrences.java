class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i : arr){
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for(int i : countMap.values()){
            if(set.contains(i))
                return false;

            set.add(i);
        }

        return true;
    }
}