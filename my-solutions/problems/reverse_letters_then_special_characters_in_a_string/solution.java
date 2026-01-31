class Solution {
    public String reverseByType(String s) {
    ArrayList<Character> a = new ArrayList<>();
    ArrayList<Character> b = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                a.add(ch);
            }
            else{
                b.add(ch);
            }
        }
        Collections.reverse(a);
        Collections.reverse(b);
        int c = 0;
        int d = 0;
        StringBuilder ans = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
           if(ch >= 'a' && ch <= 'z'){
                ans.append(a.get(c));
               c++;
            }
            else{
                ans.append(b.get(d));
                d++;
            }
        }
        return ans.toString();
    }
}