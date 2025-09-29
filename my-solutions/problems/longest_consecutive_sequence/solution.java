class Solution {
    public int longestConsecutive(int[] nums) {
        
        
        if(nums.length==1)return 1;
        if(nums.length == 0) return 0;
        int max = 0;
        Set<Integer> set  = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int it: set){
            if(!set.contains(it-1)){
              int  x = it;
              int  length = 1;
                while(set.contains(x+1)){
                    x = x+1;
                    length++;
                }
                max = Math.max(length,max);
            }
        }

        return max;
        
    }
}