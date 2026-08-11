class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int n = nums.length;
        int max = 0;

        for(int num : set ){
            if(!set.contains(num-1)){
        int len  =0;
        int k=0;
            while(set.contains(num+k)){
                len ++;
                k++;
            }
            max = Math.max(max,len);
            }

        }
        return max;
    }
}