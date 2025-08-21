class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int  i = 1;i<nums.length;i++){
            if(nums[i]> list.get(list.size()-1)){
                list.add(nums[i]);
                length++;
            }
            else{
                int index = Collections.binarySearch(list,nums[i]);
                if(index<0){
                    index = -index-1;
                }
                list.set(index,nums[i]);
            }
        }
        return length;
        
    }
}