class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int s=0;
        int e =0;
        for(int i=0;i<n;i++){
            e+=weights[i];
            s=Math.max(s,weights[i]);
        }
        int ans = -1;
        while(s<=e){
            int mid = s +(e-s)/2;
            if(helper(weights,days,mid)==true){
                ans =mid;
                e=mid-1;
            }else{
                s=mid +1;
            }
        }
        return ans;
    }
    public boolean helper(int []arr,int days,int cap){
        int sum =0;
        int count =1;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>cap){
                count++;
                sum=0;
                sum +=arr[i];
            }
            
        }
        if(count<=days){
            return true;
        }
        return false;
    }
}