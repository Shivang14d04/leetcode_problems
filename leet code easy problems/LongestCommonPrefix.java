import java.util.*;
public class LongestCommonPrefix{
    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        System.out.println(solution(strs));

    }
    public static String solution(String [] strs ){
       StringBuilder string = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        for(int i = 0;i<Math.min(first.length() , last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                return string.toString();
            }
            string.append(first.charAt(i));

        }
        return string.toString();
    }
}