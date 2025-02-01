public class DetermineIfStringHalvesAreAlike{
    public static void main(String[] args) {
        String s = "textbook";
        char[] arr = s.toCharArray();
        int counta=0;
        int countb=0;
       for(int i = 0;i<arr.length/2;i++){
        if(arr[i]=='a'|| arr[i]=='e'|| arr[i]=='i'||arr[i]=='o'|| arr[i]=='u'||arr[i]=='A'|| arr[i]=='E'|| arr[i]=='I'||arr[i]=='O'|| arr[i]=='U'){
            counta++;

        }

       } 
       for(int i = arr.length/2;i<arr.length;i++){
        if(arr[i]=='a'|| arr[i]=='e'|| arr[i]=='i'||arr[i]=='o'|| arr[i]=='u'||arr[i]=='A'|| arr[i]=='E'|| arr[i]=='I'||arr[i]=='O'|| arr[i]=='U'){
            countb++;

        }

       }
       if(counta==countb){
        System.out.println(true);
       } 
      else{ 
       System.out.println(false);
      }         
    }
}