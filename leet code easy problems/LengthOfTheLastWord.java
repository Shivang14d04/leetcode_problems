public class LengthOfTheLastWord{
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
         String [] arr = s.split("\\s+");
         System.out.println(arr[arr.length-1].length());

    }
    
}