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
}