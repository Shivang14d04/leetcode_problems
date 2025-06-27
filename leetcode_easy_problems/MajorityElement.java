public class MajorityElement{
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        System.out.println(solution(nums));       
    }
    public static int solution(int [] nums){
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