class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int operation = 0;
        for(int i = 0;i < nums.length;i++){
            int current = nums[i];
            int needed = k - current;
            boolean isHaveKey = map.containsKey(needed);
            if(isHaveKey){
                operation++;
                map.put(needed, map.getOrDefault(needed, 0) - 1);
                if(map.get(needed) <= 0)
                    map.remove(needed);
            }else{
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }
        return operation;
    }
}