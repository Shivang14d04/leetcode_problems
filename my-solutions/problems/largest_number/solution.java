class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        int i = 0;
        for(int num : nums){
            arr[i++] = String.valueOf(num);
        }
        Arrays.sort(arr,(a,b)-> (b+a).compareTo(a+b));
        String res = String.join("", arr);
        return res.charAt(0)=='0' ? "0" : res;
    }
}