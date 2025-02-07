
public class MergeStringsAlternatively{
    public static void main(String[] args){
        String word1 = "ab";
        String word2 = "pqrs";
        int i =0;
        StringBuilder string = new StringBuilder();
        while(i<word1.length()|| i< word2.length()){
            if(i<word1.length()){
                string.append(word1.charAt(i));
            }
            if(i< word2.length()){
                string.append(word2.charAt(i));
            }
            i++;
        }
        System.out.println(string.toString());
    }

}