public class LongPressedName{
    public static void main(String[] args) {
        String name = "saeed";
        String typed = "ssaedd";
        int i = 0 , j  = 0;
        while(j<typed.length()){
            if(i< name.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if(j>0 && typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }
            else{
                System.out.println(false);
                return;
            }
        }

        if(i==name.length()){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}