class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) count.put(num, count.getOrDefault(num,0)+num);
        List<Integer> unique = new ArrayList<>(count.keySet());
        Collections.sort(unique);
        int earn1 = 0 , earn2 = 0;
        for(int i =0;i< unique.size();i++){
            int curEarn = count.get(unique.get(i));
            if(i>0 && unique.get(i)== unique.get(i-1)+1){
                int temp = earn2 ;
                earn2 = Math.max(curEarn + earn1, earn2);
                earn1 = temp;
            }
            else{
                int temp = earn2;
                earn2 = curEarn + earn2;
                earn1 = temp;
            }
        }
        return earn2;
    }
}