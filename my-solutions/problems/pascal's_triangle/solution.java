class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> List  = new ArrayList<>();

        for(int i = 1;i<=numRows;i++){
            List.add(generateRow(i));
        }
        return List;
    }
    public List<Integer> generateRow(int row){
        long  ans = 1;
        List<Integer> CurrRow  = new ArrayList<>();
        CurrRow.add(1);
        for(int col = 1;col<row;col++){
            ans = ans*(row-col);
            ans  = ans/col;
            CurrRow.add((int)(ans));
        }
        return CurrRow;
    }
}