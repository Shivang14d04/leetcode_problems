
import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, ans, result, 0, 0);
        return result;
    }

    public void helper(int[] arr, int target, List<Integer> ans, List<List<Integer>> result, int sum, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(ans));
            return;
        }

        if (sum > target) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            ans.add(arr[i]);
            helper(arr, target, ans, result, sum + arr[i], i + 1);
            ans.remove(ans.size() - 1);
        }
    }

}
