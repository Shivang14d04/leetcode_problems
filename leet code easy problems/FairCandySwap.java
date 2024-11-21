
import java.util.Arrays;

class FairCandySwap{
    public static void main(String[] args) {
    int [] aliceSizes = {1,1};
    int [] bobSizes ={2,2};
    System.out.println(Arrays.toString(answer(aliceSizes,bobSizes)));

    }
    public static int [] answer(int [] aliceSizes , int [] bobSizes){
              int sum1 =0;
      int sum2 = 0;
      for(int candies : aliceSizes) sum1 += candies;
      for(int candies : bobSizes) sum2 +=candies;
      int n = aliceSizes.length , m = bobSizes.length;
      for(int i =0;i<n;i++){
        for(int j =0;j<m;j++){
            if((sum1 - aliceSizes[i] +bobSizes[j])  == (sum2 - bobSizes[j] +aliceSizes[i])){
                return new int[] {aliceSizes[i] , bobSizes[j]};
            }
        }
      }
      return new int [0]; 
    }
}