class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n  = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int  i = 0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j  = i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k = n-1;
                int l = j+1;
                while(l<k){
                    long sum = (long)nums[i] + nums[j] + nums[k]+nums[l];
                    if(sum<target){
                        l++;
                    }
                    else if(sum== target){
  List<Integer> list  = Arrays.asList(nums[i],nums[j],nums[l],nums[k]);
                        ans.add(list);
                        l++;
                        k--;
                        while(l<k && nums[l]==nums[l-1]){
                            l++;
                        }
                        while(l<k && nums[k]== nums[k+1]){
                            k--;
                        }                       
                    }
                    else{
                       k--;
                    }
                }
            }
        }
        return ans;
        
    }
}