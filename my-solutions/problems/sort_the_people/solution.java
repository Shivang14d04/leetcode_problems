class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer,String> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        int j = 0;
        for(int i = n-1;i>=0;i--){
            names[j++] = map.get(heights[i]);
        }
        return names;
    }
}