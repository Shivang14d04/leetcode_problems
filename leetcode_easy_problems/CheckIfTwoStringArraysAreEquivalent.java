
public class CheckIfTwoStringArraysAreEquivalent{
    public static void main(String[] args) {
        String [] word1 = {"ab", "c"};
        String [] word2 = {"a", "bc"};
        System.out.println(solution(word1, word2));
    }
    public static Boolean solution(String[] word1 , String [] word2){
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();        
        for(int i =0;i<word1.length;i++){
            a.append(word1[i]);
        }
        for(int i = 0;i< word2.length;i++){
            b.append(word2[i]);
        }

        if(a.toString().equals(b.toString())){
            return true;}
            else{}
             
        return false;           
    }
    }
