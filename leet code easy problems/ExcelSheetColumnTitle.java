public class ExcelSheetColumnTitle{
    public static void main(String[] args){
        int columnNumber = 701;
        StringBuilder ans = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            ans.append((char)((columnNumber%26)+'A'));
            columnNumber = columnNumber/26;
        }
        System.out.println(ans.reverse().toString());        
    }
}