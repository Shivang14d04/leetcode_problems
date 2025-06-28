
import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        int n = input.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = input.nextInt();
        }
        ArrayList<Integer> p = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        CombinationSum(p, candidates, target, result, 0);
        System.out.println(result);

    }

    public static void CombinationSum(ArrayList<Integer> p, int[] candidates, int sum, List<List<Integer>> result, int index) {
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
