public class ReverseWordsInAStringIII{
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String [] ans = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i =0;i< ans.length;i++){
            result.append(new StringBuilder(ans[i]).reverse());
            if(i==ans.length-1){
                break;
            }            
            result.append(" ");

        }
        System.out.println(result.toString());        
    }
    
}