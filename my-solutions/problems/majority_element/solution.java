class Solution {
    public int majorityElement(int[] nums) {
        int n =  nums.length;
        int majority = nums[0];
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num)> max){
                max = map.get(num);
                majority = num;
            }
        }
       

        return majority;
        
    }
}