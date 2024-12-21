class Solution {
    public int[] sortArrayByParity(int[] nums) {
     int [] answer = new int[nums.length];
     int k = 0;
     int b = nums.length-1;
     for(int i =0;i<nums.length;i++){
        if(nums[i]%2==0){
            answer[k] = nums[i];
            k++;
        }
        else{
            answer[b] = nums[i];
            b--;
        }
     }
     return answer;   
    }
}