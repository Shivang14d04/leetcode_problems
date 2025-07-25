
import java.util.*;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] nums = new int[9];
        for (int i = 1; i < 10; i++) {
            nums[i - 1] = i;
        }

        helper(k, n, ans, result, nums, 0, 0);
        return result;
    }

    public void helper(int k, int target, List<Integer> ans, List<List<Integer>> result, int[] arr, int sum, int index) {
        if (sum == target && ans.size() == k) {
            result.add(new ArrayList<>(ans));
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target) {
                break;
            }
            ans.add(arr[i]);
            helper(k, target, ans, result, arr, sum + arr[i], i + 1);
            ans.remove(ans.size() - 1);
        }
    }

}
