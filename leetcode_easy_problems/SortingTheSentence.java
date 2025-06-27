public class SortingTheSentence{
    public static void main(String[] args){
        String s = "is2 sentence4 This1 a3";
                String [] str = s.split(" ");
        String [] result = new String[str.length];
        StringBuilder ans = new StringBuilder();
        int i;
        for(String element : str){
            i = (int)(element.charAt(element.length()-1)) - '0';
            result[i-1] = element.substring(0,element.length()-1);
        }
        for( i = 0;i< result.length-1;i++){
            ans.append(result[i]).append(" ");
        }
        ans.append(result[i]);
        System.out.println(ans.toString());
    }
}