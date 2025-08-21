import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
          int n = nums.length;
        int [] dp = new int[n];
        int [] hash = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            hash[i] = i; // initialize parent
            for(int prevIndex = 0; prevIndex < i; prevIndex++){
                if(nums[i]%nums[prevIndex] == 0 && 1 + dp[prevIndex] > dp[i]){
                    dp[i] = 1 + dp[prevIndex];
                    hash[i] = prevIndex;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;
        for(int i = 0; i < n; i++){
            if(dp[i] > ans){
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);

        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        Collections.reverse(temp); // ✅ to get correct LIS
        

        return temp;
    }
}