class Solution {
    public int majorityElement(int[] nums) {
        int count =1;
        int n = nums.length;
     for(int i =0;i< n ;i++){
        for(int j =i+1;j<n;j++){
            if(nums[i]== nums[j]){
                count++;
            }
        }
        if(count> n/2){
            return nums[i];
        }
        count =1;
     } 
     return -1;  
    }
}