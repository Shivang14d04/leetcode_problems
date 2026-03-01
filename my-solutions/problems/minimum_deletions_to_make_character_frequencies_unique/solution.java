class Solution {
    public int minDeletions(String s) {
    Map<Character, Integer> map = new HashMap<>();  
    Set<Integer> set = new HashSet<>();
    int n = s.length();
    int count = 0;
    for(int i =0;i<n;i++){
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
    } 
    for(Map.Entry<Character, Integer> entry : map.entrySet()){
        int temp = entry.getValue();
        while(set.contains(temp)){
            temp--;
            count++;
        }
        if(temp !=0)
        set.add(temp);
    }
    return count;
    }
}