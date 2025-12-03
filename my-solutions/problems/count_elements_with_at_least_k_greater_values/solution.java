class Solution {
    public int countElements(int[] nums, int k) {
        if(nums.length==0)return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n  = clone.length;
        for(int i = 0;i< clone.length;i++){
            map.put(clone[i], n-i-1);
        }

        int count = 0;
        for(int num: nums){
            if(map.get(num) >=k){
                count++;
            }
        }
        return count;
    }
}