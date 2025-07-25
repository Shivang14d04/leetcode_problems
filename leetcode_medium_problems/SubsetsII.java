
import java.util.*;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        helper(nums, ans, result, 0);
        return result;
    }

    public void helper(int[] arr, List<Integer> ans, List<List<Integer>> result, int index) {

        result.add(new ArrayList(ans));
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            ans.add(arr[i]);

            helper(arr, ans, result, i + 1);
            ans.remove(ans.size() - 1);
        }

    }
}
