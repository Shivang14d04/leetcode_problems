class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] nextg = new int[10001];
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nextg[nums2[i]] = -1;
            }
            else{
                nextg[nums2[i]] = st.peek();
            }
            st.push(nums2[i]);
        }

        for(int i = 0;i< nums1.length;i++){
            nums1[i] = nextg[nums1[i]];
        }
        return nums1;
        
    }
}