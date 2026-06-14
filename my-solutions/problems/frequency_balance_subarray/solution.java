import java.util.*;

class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            HashMap<Integer, Integer> cnt = new HashMap<>();
            HashMap<Integer, Integer> freqCnt = new HashMap<>();

            for (int j = i; j < n; j++) {

                int x = nums[j];

                int oldFreq = cnt.getOrDefault(x, 0);
                int newFreq = oldFreq + 1;

                cnt.put(x, newFreq);

                if (oldFreq > 0) {
                    freqCnt.put(oldFreq, freqCnt.get(oldFreq) - 1);

                    if (freqCnt.get(oldFreq) == 0) {
                        freqCnt.remove(oldFreq);
                    }
                }

                freqCnt.put(newFreq,
                        freqCnt.getOrDefault(newFreq, 0) + 1);

                boolean valid = false;

                // Only one distinct value
                if (cnt.size() == 1) {
                    valid = true;
                }

                // Frequencies must be f and 2f
                else if (freqCnt.size() == 2) {

                    ArrayList<Integer> list = new ArrayList<>(freqCnt.keySet());

                    int a = list.get(0);
                    int b = list.get(1);

                    int small = Math.min(a, b);
                    int large = Math.max(a, b);

                    if (large == 2 * small) {
                        valid = true;
                    }
                }

                if (valid) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}