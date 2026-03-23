class Solution {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        int[][] ans  = new int[n][2];
        for(int i =0;i<n;i++){
            String a = Integer.toBinaryString(nums[i]);
            StringBuilder b = new StringBuilder(a);
           StringBuilder c =  b.reverse();
            String d = c.toString();
            int e= Integer.parseInt(d,2);
            ans[i][0] = nums[i];
            ans[i][1] = e;
        }
        Arrays.sort(ans,(a,b)->{
            if(a[1] != b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
               int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = ans[i][0];
        }

        return result;
    }
}