class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> p = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        CombinationSum(p, candidates, target, result, 0); // added index to avoid duplicates
        return result;
    }

    public void CombinationSum(ArrayList<Integer> p, int[] candidates, int sum, List<List<Integer>> result, int index) {
        if (sum == 0) {
            result.add(new ArrayList<>(p)); // Add a copy of current list
            return;
        }

        if (sum < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            p.add(candidates[i]);
            CombinationSum(p, candidates, sum - candidates[i], result, i); // allow reuse
            p.remove(p.size() - 1); // backtrack
        }
    }
}
