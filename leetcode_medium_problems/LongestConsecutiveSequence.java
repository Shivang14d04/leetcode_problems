import java.util.*;
public class LongestConsecutiveSequence{
    // time complexity O(nlogn)
        public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int length = 0;
        if(nums.length==1)return 1;
        if(nums.length == 0) return 0;
        int max = 0;
        for(int i =1;i<nums.length;i++){
            if(nums[i-1] +1 == nums[i]){
                length++;
            }
            else if(nums[i-1]== nums[i]){
                continue;
            }
            else{
                length =0;
            }
            max = Math.max(length,max);
        }
        return max +1;
        
    }
    // time complexity O(n)
    public int longestConsecutive2(int[] nums) {

        if (nums.length == 1)
            return 1;
        if (nums.length == 0)
            return 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int x = it;
                int length = 1;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    length++;
                }
                max = Math.max(length, max);
            }
        }

        return max;

    }
}