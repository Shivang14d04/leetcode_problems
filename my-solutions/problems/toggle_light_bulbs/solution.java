class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Set<Integer> set = new HashSet<>();
        int n = bulbs.size();
        for(int i =0;i<n;i++){
            if(set.contains(bulbs.get(i))){
                set.remove(bulbs.get(i));
            }
            else{
                set.add(bulbs.get(i));
            }
        }
        List<Integer> ans  = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}