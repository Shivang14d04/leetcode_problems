
import java.util.*;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(ans, result, nums, 0);
        return result;
    }

    public void generateSubsets(List<Integer> ans, List<List<Integer>> result, int[] nums, int index) {
        // Add a copy of current subset
        result.add(new ArrayList<>(ans));

        for (int i = index; i < nums.length; i++) {

            ans.add(nums[i]);

            generateSubsets(ans, result, nums, i + 1);

            ans.remove(ans.size() - 1);
        }
    }
}
