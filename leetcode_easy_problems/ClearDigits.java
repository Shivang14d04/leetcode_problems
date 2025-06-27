public class ClearDigits{
    public static void main(String[] args){
        String s = "cb34";
      StringBuilder b = new StringBuilder(s.toLowerCase());
        for(int i = 1; i <b.length();i++){
            if(b.charAt(i) <= 57 && b.charAt(i) >=48){
                if(b.charAt(i-1)<=122 && b.charAt(i-1)>=97){
                       b.deleteCharAt(i-1);
                       b.deleteCharAt(i-1);
                       i-=2;
                }
                else{
                   b.deleteCharAt(i);
                   i--;
                }
            }
   
        }
        System.out.println(b.toString());        
    }
}