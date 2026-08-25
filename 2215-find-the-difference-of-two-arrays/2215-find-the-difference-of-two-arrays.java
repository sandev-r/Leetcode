class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }

        for (int n : nums2) {
            set2.add(n);
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int n : set1) {
            if (!set2.contains(n)) {
                first.add(n);
            }
        }

        for (int n : set2) {
            if (!set1.contains(n)) {
                second.add(n);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(first);
        result.add(second);

        return result;
    }
}